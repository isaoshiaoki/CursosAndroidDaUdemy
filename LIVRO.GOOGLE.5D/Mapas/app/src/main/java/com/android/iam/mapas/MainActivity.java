package com.android.iam.mapas;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Exemplos de Layouts
 *
 * @author rlecheta
 */
public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        String[] items = new String[]{
                "MapFragment por XML",
                "MapFragment por API",
                "MapFragment por XML + GPS",
                "Rota",
                "GeoCoder",
                "Sair"
        };

        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        // Lista de permissões necessárias.
        String permissions[] = new String[]{
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
        };

        // Valida lista de permissões.
        PermissionUtils.validate(this, 0, permissions);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                toast("Permissão de GPS negada");
                finish();
                return;
            }
        }

        // Permissões concedidas, pode entrar.
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, ExemploMapaV2.class));
                    break;
                case 1:
                    startActivity(new Intent(this, ExemploMapaV2_API.class));
                    break;
                case 2:
                    startActivity(new Intent(this, ExemploMapaV2_GPS.class));
                    break;
                case 3:
                    String origem = "-25.443195, -49.280977 ";
                    String destino = "-25.442207, -49.278403";
                    // http://maps.googleapis.com/maps/api/directions/json?origin=-25.443195,-49.280977&destination=-25.442207, -49.278403&sensor=true&mode=driving
//				String url = "http://maps.google.com/maps?f=d&saddr="+partida+"&daddr="+destino+"&hl=pt";
                    String url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + origem + "&destination=" + destino + "&sensor=true&mode=driving";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    break;
                case 4:
                    testeGeoCoder();
                    break;
                default:
                    finish();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Erro :" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void testeGeoCoder() {
        new Thread() {
            public void run() {
                try {
                    Geocoder gc = new Geocoder(getBaseContext(), new Locale("pt", "BR"));
                    List<Address> list = gc.getFromLocationName("Av Paulista - SP", 10);
                    toast("addresses: " + list);
                } catch (IOException e) {
                    toast("Erro: " + e.getMessage());
                }
            }
        }.start();
    }

    private void toast(final String string) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(getBaseContext(), string, Toast.LENGTH_SHORT).show();
            }
        });
    }

    ;
}