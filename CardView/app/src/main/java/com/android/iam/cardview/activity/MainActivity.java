package com.android.iam.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.android.iam.cardview.R;
import com.android.iam.cardview.adapter.PostagemAdapter;
import com.android.iam.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Define layout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2 );
        recyclerPostagem.setLayoutManager( layoutManager );

        //define adapter
        prepararPostagens();

        PostagemAdapter adapter = new PostagemAdapter( postagens );
        recyclerPostagem.setAdapter( adapter );

    }

    public void prepararPostagens(){

        Postagem p;

        p = new Postagem("Jamilton Damasceno", "#TBT viagem legal!", R.drawable.imagem1 );
        postagens.add(p);

        p = new Postagem("Hotel JM", "Viaje, aproveite nossos descontos!", R.drawable.imagem2 );
        postagens.add(p);

        p = new Postagem("Maria Luiza", "#Paris!!", R.drawable.imagem3);
        postagens.add(p);

        p = new Postagem("Marcos Paulo", "Que foto linda!", R.drawable.imagem4);
        postagens.add(p);

    }

}
