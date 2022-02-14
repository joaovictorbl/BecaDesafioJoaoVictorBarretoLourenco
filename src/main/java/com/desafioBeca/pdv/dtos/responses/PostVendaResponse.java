package com.desafioBeca.pdv.dtos.responses;

import lombok.Data;

@Data
public class PostVendaResponse {

    private Double valorFinal;
    private Integer quantidadeFinal;
    private GetProdutoObterResponse produto;
    private Integer id;

}
