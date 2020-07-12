package com.android.iam.cursofirebase.Classes;

import com.google.firebase.database.Exclude;

/**
 * Created by Daniel Lopes on 01/09/2017.
 */

public class Usuario {


    private String email;
    private String senha;
    private String nome;
    private String tipoUsuario;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Exclude
    public String getSenha() {
        return senha;
    }

    @Exclude
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
