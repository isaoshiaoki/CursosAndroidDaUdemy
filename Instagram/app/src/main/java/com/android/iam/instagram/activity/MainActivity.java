package com.android.iam.instagram.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.android.iam.instagram.R;
import com.android.iam.instagram.fragment.FeedFragment;
import com.android.iam.instagram.fragment.PerfilFragment;
import com.android.iam.instagram.fragment.PesquisaFragment;
import com.android.iam.instagram.fragment.PostagemFragment;
import com.android.iam.instagram.helper.ConfiguracaoFirebase;
//import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

   // private FirebaseAuth autenticacao;
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
        //autenticacao= ConfiguracaoFirebase.getFirebaseAutenticacao();



        //configuracao do bottom navigation
        configuraBottomNavigationView();

        //carrega inicialmente o FeedFragment
        android.support.v4.app.FragmentManager fragmentManager=fragmentManager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewPager,new FeedFragment()).commit();


    }



    //metodo de conf do botton navigation


    private void configuraBottomNavigationView(){

        BottomNavigationViewEx bottomNavigationViewEx=findViewById(R.id.bottomNavigation);

        //conf iniciais
        bottomNavigationViewEx.enableAnimation(true);

        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
        bottomNavigationViewEx.enableShiftingMode(false);


        //habilitar a navegacao

        habilitarNavegacao(bottomNavigationViewEx);

        //configura item selecionado incialmente
        Menu menu =bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(0);
        menuItem.setChecked(true);

    }


      //trata eventos de click na bottomNavigation

    private void habilitarNavegacao(BottomNavigationViewEx viewEx){

        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //FragmentManager fragmentManager=getSupportFragmentManager();
                //FragmentManager fragmentManager=getSupportFragmentManager();

                android.support.v4.app.FragmentManager fragmentManager=fragmentManager=getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();





                switch(item.getItemId()){


                    case R.id.ic_home :
                        fragmentTransaction.replace(R.id.viewPager,new FeedFragment()).commit();
                        return  true;


                    case R.id.ic_pesquisa :
                        fragmentTransaction.replace(R.id.viewPager,new PesquisaFragment()).commit();
                        return  true;


                    case R.id.ic_perfil:
                        fragmentTransaction.replace(R.id.viewPager,new PerfilFragment()).commit();
                        return  true;



                    case R.id.ic_postagem :
                        fragmentTransaction.replace(R.id.viewPager,new PostagemFragment()).commit();
                        return  true;

                }


                return false;
            }
        });
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
            //autenticacao.signOut();

        }catch(Exception e){


        }





    }
}
