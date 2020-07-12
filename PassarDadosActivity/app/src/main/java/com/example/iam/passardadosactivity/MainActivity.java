package com.example.iam.passardadosactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button botao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao=(Button) findViewById(R.id.botaoId);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

        intent.putExtra("mensagem","mensagem da intent");
                //startActivity(new Intent(MainActivity.this,Main2Activity.class));

                startActivity(intent);

            }
        });
    }
}
