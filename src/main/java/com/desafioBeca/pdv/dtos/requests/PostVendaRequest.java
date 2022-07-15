package com.desafioBeca.pdv.dtos.requests;

import com.desafioBeca.pdv.dtos.responses.GetProdutoObterResponse;
import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostVendaRequest {

    @DecimalMin("0.99")
    @DecimalMax("9999.00")
    private Double valorFinal;
    @Size(min = 1, max = 8,message = "Caompo Obrigatorio!")
    private Integer quantidadeFinal;
    @NotBlank(message = "Campo Obrigatorio!")
    private GetProdutoObterResponse produto;


}
