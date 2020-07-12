package com.android.iam.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private RadioGroup radioGrupo;
private RadioButton radioButtonEscolhido;
private Button botaoEscolher;
private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textoExibicao=(TextView) findViewById(R.id.textoId);
        radioGrupo=(RadioGroup) findViewById(R.id.radioGroupId);
         botaoEscolher=(Button) findViewById(R.id.botaoId);




         botaoEscolher.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
int idRadioButtonEscolhido=radioGrupo.getCheckedRadioButtonId();

if(idRadioButtonEscolhido > 0){
radioButtonEscolhido=(RadioButton) findViewById(idRadioButtonEscolhido);
textoExibicao.setText(radioButtonEscolhido.getText());


}


             }
         });
    }





}
