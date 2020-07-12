package com.android.iam.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    // cria uma instacia
    private DatabaseReference databaseReferencia=FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia=databaseReferencia.child("ususarios");
    private DatabaseReference produtoReferencia=databaseReferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




       /* Usuario usuario=new Usuario();
         usuario.setNome("paula");
         usuario.setSobrenome("cardoso");
        usuario.setIdade("23");
        usuario.setSexo("Feminino");*/



        /*Produtos produto=new Produtos();
        produto.setCor("Branco");
        produto.setDescricao("Tv");
        produto.setFabricante("LG");


        produtoReferencia.child("002").setValue(produto);
*/

        //cria um no na referencia raiz
       // databaseReferencia.child("pontos").setValue("200");
        //usuarioReferencia.child("003").child("nome").setValue("Mariana Beltrana");



// para mudar a busca basta mudar p objeto chamador   usuarioReferencia   produtoReferencia
        usuarioReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIRBASE",dataSnapshot.getValue().toString());



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}
