package com.android.iam.cardview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.iam.cardview.R;
import com.android.iam.cardview.model.Postagem;

import java.util.List;

/**
 * Created by jamiltondamasceno
 */

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> listaPostagens) {
        this.postagens = listaPostagens;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.postagem_detalhe, parent, false);

        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Postagem postagem = postagens.get( position );
        holder.textNome.setText( postagem.getNome() );
        holder.textPostagem.setText( postagem.getPostagem() );
        holder.imagePostagem.setImageResource( postagem.getImagem() );

    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textNome;
        private TextView textPostagem;
        private ImageView imagePostagem;


        public MyViewHolder(View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            textPostagem = itemView.findViewById(R.id.textPostagem);
            imagePostagem = itemView.findViewById(R.id.imagePostagem);
        }
    }

}
