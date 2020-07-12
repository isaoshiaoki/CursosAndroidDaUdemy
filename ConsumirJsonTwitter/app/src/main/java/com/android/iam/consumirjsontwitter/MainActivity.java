package com.android.iam.consumirjsontwitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends android.app.ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

new DownloadJsonAsyncTask().execute("https://api.twitter.com/1/trends/23424768.json");




    }


    @Override
	protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Trend trend = (Trend)l.getAdapter().getItem(position);

		android.content.Intent it = new android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(trend.url));
		startActivity(it);
	}



class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Trend>> {

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = ProgressDialog.show(MainActivity.this, "Aguarde",
					"Baixando JSON, Por Favor Aguarde...");
		}

@Override
		protected List<Trend> doInBackground(String... params) {
			String urlString = params[0];

			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(urlString);

			try {
				HttpResponse response = httpclient.execute(httpget);

				HttpEntity entity = response.getEntity();

				if (entity != null) {
					InputStream instream = entity.getContent();

					String json = toString(instream);
					instream.close();

					List<Trend> trends = getTrends(json);

					return trends;
				}
			} catch (Exception e) {
				Log.e("DEVMEDIA", "Falha ao acessar Web service", e);
			}
			return null;
		}

		private List<Trend> getTrends(String jsonString) {

			List<Trend> trends = new ArrayList<Trend>();

			try {
				JSONArray trendLists = new JSONArray(jsonString);
				JSONObject trendList = trendLists.getJSONObject(0);
				JSONArray trendsArray = trendList.getJSONArray("trends");

				JSONObject trend;

				for (int i = 0; i < trendsArray.length(); i++) {
					trend = new JSONObject(trendsArray.getString(i));

					Log.i("DEVMEDIA", "nome=" + trend.getString("name"));

					Trend objetoTrend = new Trend();
					objetoTrend.name = trend.getString("name");
					objetoTrend.url = trend.getString("url");

					trends.add(objetoTrend);
				}
			} catch (JSONException e) {
				Log.e("DEVMEDIA", "Erro no parsing do JSON", e);
			}

			return trends;
		}
@Override
		protected void onPostExecute(List<Trend> result) {
			super.onPostExecute(result);
			dialog.dismiss();
			if (result.size() > 0) {
				ArrayAdapter<Trend> adapter = new ArrayAdapter<Trend>(
						MainActivity.this,
						android.R.layout.simple_list_item_1, result);
				setListAdapter(adapter);

			} else {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this).setTitle("Atenção")
						.setMessage("Não foi possivel acessar essas informções...")
						.setPositiveButton("OK", null);
				builder.create().show();
			}
		}

		private String toString(InputStream is) throws IOException {

			byte[] bytes = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int lidos;
			while ((lidos = is.read(bytes)) > 0) {
				baos.write(bytes, 0, lidos);
			}
			return new String(baos.toByteArray());
		}
	}

}

class Trend {
	String name;
	String url;

	@Override
	public String toString() {
		return name;
	}
}










