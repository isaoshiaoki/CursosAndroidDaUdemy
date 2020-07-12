package com.android.iam.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private ListView listaItens;
    private String[] itens = {
            "Áries", "Touro","Gêmeos","Câncer","Leão","Virgem",
            "Libra","Escorpião","Sagitário","Capricórnio","Aquário",
            "Peixes"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaItens= findViewById(R.id.listViewId);

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,itens);


        listaItens.setAdapter(adaptador);

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int codigoPosicao=position;
                String valorClicado=listaItens.getItemAtPosition(codigoPosicao).toString();
                Toast.makeText(getApplicationContext(),valorClicado,Toast.LENGTH_LONG).show();
            }
        });



    }




}
