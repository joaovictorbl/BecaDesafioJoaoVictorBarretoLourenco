package com.desafioBeca.pdv.dtos.requests;

import com.desafioBeca.pdv.dtos.responses.GetProdutoObterResponse;
import lombok.*;

import javax.validation.constraints.*;

@Data
public class PostVendaRequest {

    @DecimalMin("0.99")
    @DecimalMax("9999.00")
    private Double valorFinal;
    @Min(value = 1, message = "quantidade minimo exigido!")
    @Max(value = 99, message = "quantidade excedida !")
    private Integer quantidadeFinal;
    private GetProdutoObterResponse produto;


}
