package com.android.iam.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textoExibicao=(TextView) findViewById(R.id.textoExibicaoId) ;


        seekBar=(SeekBar) findViewById(R.id.seekBarId);
seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    //chamado qdo se movimenta o seekbar
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textoExibicao.setText("Progresso: " + progress +" / " + seekBar.getMax());


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(MainActivity.this , "SeekBar pressionado" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        Toast.makeText(MainActivity.this , "SeekBar não esta pressionado", Toast.LENGTH_SHORT).show();

    }
});

    }











}
