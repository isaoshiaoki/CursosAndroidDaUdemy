package com.android.iam.cursofirebase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

import com.android.iam.cursofirebase.R;
import com.google.firebase.auth.FirebaseAuth;

public class cadastroUsuario extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private EditText nome;
    private RadioButton rbAdmin;
    private RadioButton rbAtend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);


    }
}
