package com.desafioBeca.pdv.dtos.responses;

public class PostClienteResponse  {

    private String nome;
    private Integer telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
}
