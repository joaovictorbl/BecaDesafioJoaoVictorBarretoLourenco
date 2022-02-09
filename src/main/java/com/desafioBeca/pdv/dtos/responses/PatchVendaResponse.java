package com.desafioBeca.pdv.dtos.responses;

import lombok.*;

@Data
public class PatchVendaResponse {

    private Double valorFinal;
    private Integer quantidadeFinal;
    private  GetProdutoObterResponse produto;

}
