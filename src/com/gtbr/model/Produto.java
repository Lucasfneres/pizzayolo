package com.gtbr.model;

public class Produto {

    private Integer id;
    private String nome;
    private Float valor;
    private Integer codigoDeBarras;


    public Produto(Integer id, String nome, Float valor, Integer codigoDeBarras) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.codigoDeBarras = codigoDeBarras;


    }


    public Integer getId () {
        return this.id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getCodigoDeBarras() {

        return this.codigoDeBarras;
    }

    public void setCodigoDeBarras(Integer codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    @Override
    public String toString() {
        return id + ":" + nome + ":" + valor + ":" + codigoDeBarras + ";";
    }

}
