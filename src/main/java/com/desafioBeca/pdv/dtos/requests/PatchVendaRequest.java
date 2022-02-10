package com.desafioBeca.pdv.dtos.requests;

import com.desafioBeca.pdv.dtos.responses.GetProdutoObterResponse;
import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PatchVendaRequest {

    @DecimalMin("0.10")
    @DecimalMax("99999.00")
    private Double valorFinal;
    @Size(min = 1, max = 8,message = "Caompo Obrigatorio!")
    private Integer quantidadeFinal;
    @NotBlank(message = "Campo Obrigatorio!")
    private GetProdutoObterResponse produto;

}
