package com.desafioBeca.pdv.model;

public class Fucionario extends Pessoa {

    private Integer id;

    public Fucionario() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
