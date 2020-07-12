package com.android.iam.instagram.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.android.iam.instagram.R;
import com.android.iam.instagram.helper.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configurar toobar

        //toolbar tem multiple opcao: android.support.v7.widget.Toolbar ou  android.widget.Toolbar



        android.support.v7.widget.Toolbar toolbar= findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Instagram");
        setSupportActionBar(toolbar);


//configuracao de objetos
        autenticacao= ConfiguracaoFirebase.getFirebaseAutenticacao();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }

@Override
    public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {

        case R.id.menu_sair:
            deslogarUsuario();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        break;




    }








return super.onOptionsItemSelected(item);
}

private void deslogarUsuario(){

try {
autenticacao.signOut();

}catch(Exception e){


}





    }
}
