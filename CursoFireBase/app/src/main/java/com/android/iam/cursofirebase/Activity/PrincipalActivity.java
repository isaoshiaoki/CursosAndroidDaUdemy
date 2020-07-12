package com.android.iam.cursofirebase.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.iam.cursofirebase.Classes.Usuario;
import com.android.iam.cursofirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class PrincipalActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;
    private DatabaseReference referenciaFirebase;
    private TextView tipoUsuario;
    private Usuario usuario;
    private String tipoUsuarioEmail;
    private Menu menu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tipoUsuario = (TextView) findViewById(R.id.txtTipoUsuario);

        autenticacao = FirebaseAuth.getInstance();

        referenciaFirebase = FirebaseDatabase.getInstance().getReference();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        menu.clear();

        this.menu1 = menu;

        //recebendo o e-mail do usuário logado no momento
        String email = autenticacao.getCurrentUser().getEmail().toString();


        referenciaFirebase.child("usuarios").orderByChild("email").equalTo(email.toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    tipoUsuarioEmail = postSnapshot.child("tipoUsuario").getValue().toString();

                    tipoUsuario.setText(tipoUsuarioEmail);

                    menu1.clear();

                    if (tipoUsuarioEmail.equals("Administrador")) {
                        getMenuInflater().inflate(R.menu.menu_admin, menu1);
                    } else if (tipoUsuarioEmail.equals("Atendente")) {
                        getMenuInflater().inflate(R.menu.menu_atend, menu1);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_add_usuario) {
            abrirTelaCadastroUsuario();
        } else if (id == R.id.action_sair_admin) {
            deslogarUsuario();
        } else if (id == R.id.action_sair_atend) {
            deslogarUsuario();
        } else if (id == R.id.action_cad_foto_perfil_atend) {
            uploadFotoPerfil();
        }

        return super.

                onOptionsItemSelected(item);

    }


    private void abrirTelaCadastroUsuario() {
        Intent intent = new Intent(PrincipalActivity.this, CadastroUsuarioActivity.class);

        startActivity(intent);
    }

    private void deslogarUsuario() {

        autenticacao.signOut();

        Intent intent = new Intent(PrincipalActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void uploadFotoPerfil() {
        Intent intent = new Intent(PrincipalActivity.this, UploadFotoActivity.class);
        finish();
        startActivity(intent);
    }


}
