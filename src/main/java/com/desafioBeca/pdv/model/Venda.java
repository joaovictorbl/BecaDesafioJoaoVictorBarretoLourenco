package com.desafioBeca.pdv.model;

import com.desafioBeca.pdv.model.Produto;

public class Venda extends Produto {

    private Integer id;
    private Double valorFinal;
    private Integer quantidadeFinal;

    public Venda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Integer getQuantidadeFinal() {
        return quantidadeFinal;
    }

    public void setQuantidadeFinal(Integer quantidadeFinal) {
        this.quantidadeFinal = quantidadeFinal;
    }
}
