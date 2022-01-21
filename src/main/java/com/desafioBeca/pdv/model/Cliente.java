package com.desafioBeca.pdv.model;

public class Cliente extends Pessoa {

    private Integer id;

    public Cliente() {
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
