package com.desafioBeca.pdv.dtos.responses;

import lombok.Data;

@Data
public class GetVendaListarResponse {

    private Integer id;
    private Double valorFinal;
    private Integer quantidadeFinal;
    private GetProdutoObterResponse produto;

}
