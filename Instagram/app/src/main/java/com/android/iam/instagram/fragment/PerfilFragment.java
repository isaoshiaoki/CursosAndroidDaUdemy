package com.android.iam.instagram.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.*;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.iam.instagram.R;
import com.android.iam.instagram.activity.EditarPerfilActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
      GridView gridViewPerfil;
      ProgressBar progressBar;
    ImageView imagePerfil;
    TextView textPublicacoes;
    TextView  textSeguidores;
    TextView textSeguindo;
    Button buttonEditarPerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //configuracaoes dos componentes
       View view= inflater.inflate(R.layout.fragment_perfil, container, false);
        gridViewPerfil = view.findViewById(R.id.gridViewPerfil);
           progressBar = view.findViewById(R.id.progressBarPerfil);
        imagePerfil = view.findViewById(R.id.imagePerfil);
       textPublicacoes=view.findViewById(R.id.textPublicacoes);
        textSeguidores=view.findViewById(R.id.textSeguidores);
        textSeguindo=view.findViewById(R.id.textSeguindo);
        buttonEditarPerfil=view.findViewById(R.id.buttonEditarPerfil);

        //abre edicao de perfil


        buttonEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getActivity(), EditarPerfilActivity.class);
                startActivity(i);
            }
        });


       return view;
    }

}
