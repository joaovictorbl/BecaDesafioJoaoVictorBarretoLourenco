package com.desafioBeca.pdv.model;

public class Fucionario extends Pessoa {

    private Integer id;

    @Override
    public String toString() {
        return "Fucionario{" +
                "id=" + id +
                '}';
    }

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
