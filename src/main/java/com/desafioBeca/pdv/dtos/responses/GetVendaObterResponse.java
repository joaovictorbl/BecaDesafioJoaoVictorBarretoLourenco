package com.desafioBeca.pdv.dtos.responses;

import lombok.Data;

@Data
public class GetVendaObterResponse {

    private Double valorFinal;
    private Integer quantidadeFinal;
    private GetProdutoObterResponse produto;

}
