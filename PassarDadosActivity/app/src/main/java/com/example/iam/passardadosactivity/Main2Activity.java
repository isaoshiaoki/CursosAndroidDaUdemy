package com.example.iam.passardadosactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.TextView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

texto=(TextView) findViewById(R.id.textViewId);
Bundle recebePutExtra=getIntent().getExtras();


if(recebePutExtra !=null){
    String textoEnviado= recebePutExtra.getString("mensagem");

texto.setText(textoEnviado);
}




    }
}
