package com.desafioBeca.pdv.dtos.requests;

public class PatchVendaRequest {

    private Double valorFinal;
    private Integer quantidadeFinal;
    private  Integer produto;

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
