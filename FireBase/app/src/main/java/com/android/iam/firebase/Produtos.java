package com.android.iam.firebase;

/**
 * Created by IAM on 26/03/2018.
 */

public class Produtos {

    private  String descricao;
    private  String cor;
    private  String fabricante;


    public Produtos(){


    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
