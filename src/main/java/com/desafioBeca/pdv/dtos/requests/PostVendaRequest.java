package com.desafioBeca.pdv.dtos.requests;

import com.desafioBeca.pdv.dtos.responses.GetProdutoObterResponse;
import lombok.*;

@Data
public class PostVendaRequest {

    private Double valorFinal;
    private Integer quantidadeFinal;
    private GetProdutoObterResponse produto;


}
