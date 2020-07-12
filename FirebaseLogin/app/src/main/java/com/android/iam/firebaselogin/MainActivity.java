package com.android.iam.firebaselogin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth=FirebaseAuth.getInstance();


//logout do usuarioa
       // firebaseAuth.signOut();

//-----------verifica se esta logado---------------
        if(firebaseAuth.getCurrentUser() !=null){

Log.i("verificaUsuario","LOGADO");



        }else{

            Log.i("verificaUsuario","Não LOGADO");

        }

//=--------------------------------------------------------

//-----------------------login do usuario---------------------------------

       /* firebaseAuth.signInWithEmailAndPassword("email@gmail.com","senha123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {//sucesso ao logar
                            Log.i("SignIn", "Sucesso ao logar usuário");

                        } else {// erro ao logar
                            Log.i("SignIn", "Erro ao logar usuário");


                        }
                    }
                    });*/






//------------------------cadastro de usuario-----------------------

        /*firebaseAuth.createUserWithEmailAndPassword("email@gmail.com","senha123")
        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

if(task.isSuccessful()){//sucesso ao cadastrar
    Log.i("createrUser","Sucesso ao cadastrar usuário");

}else{// erro ao cadastrar
    Log.i("createUser","Erro ao cadastrar usuário");

}




            }
        });

    */
//------------------------------------------------------------------------




}


}
