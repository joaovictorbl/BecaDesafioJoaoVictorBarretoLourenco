package com.desafioBeca.pdv.dtos.responses;

public class PostVendaResponse {

    private Double valorFinal;
    private Integer quantidadeFinal;
    private String produto;
    private Integer id;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
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
