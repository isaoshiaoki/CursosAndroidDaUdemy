package com.android.iam.whatsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.android.iam.whatsapp.R;
import com.android.iam.whatsapp.helper.Preferencias;
import com.android.iam.whatsapp.model.Mensagem;

public class MensagemAdapter extends ArrayAdapter<Mensagem> {

    private Context context;
    private ArrayList<Mensagem> mensagens;

    public MensagemAdapter(Context c, ArrayList<Mensagem> objects) {
        super(c, 0, objects);
        this.context = c;
        this.mensagens = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        // Verifica se a lista está preenchida
        if( mensagens != null ){

            // Recupera dados do usuario remetente
            Preferencias preferencias = new Preferencias(context);
            String idUsuarioRementente = preferencias.getIdentificador();

            // Inicializa objeto para montagem do layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            // Recupera mensagem
            Mensagem mensagem = mensagens.get( position );

            // Monta view a partir do xml
            if(idUsuarioRementente.equals( mensagem.getIdUsuario() )  ){
                view = inflater.inflate(R.layout.item_mensagem_direita, parent, false);
            }else {
                view = inflater.inflate(R.layout.item_mensagem_esquerda, parent, false);
            }


            // Recupera elemento para exibição
            TextView textoMensagem = (TextView) view.findViewById(R.id.tv_mensagem);
            textoMensagem.setText( mensagem.getMensagem() );



        }

        return view;

    }
}
