package com.desafioBeca.pdv.dtos.requests;

public class PostVendaRequest {

    private Double valorFinal;
    private Integer quantidadeFinal;

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
