package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostProdutoRequest {

    @NotBlank(message = "Campo Obrigatorio!")
    private String nome;
    @DecimalMin("0.01")
    @DecimalMax("9999.00")
    private Double valor;
    @Size(min = 1, max = 8,message = "Caompo Obrigatorio!")
    private Integer quantidade;
    private String descricao;

}
