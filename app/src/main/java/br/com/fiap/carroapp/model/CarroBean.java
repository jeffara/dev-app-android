package br.com.fiap.carroapp.model;

import java.io.Serializable;

/**
 * Created by jeff on 11/19/15.
 */
public class CarroBean implements Serializable {

    public CarroBean() {}

    private String nome;
    private String descricao;
    private String foto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
