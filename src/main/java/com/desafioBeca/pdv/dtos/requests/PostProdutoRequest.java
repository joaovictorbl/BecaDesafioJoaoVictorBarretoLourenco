package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

import javax.validation.constraints.*;

@Data
public class PostProdutoRequest {

    @NotBlank(message = "Campo Obrigatorio!")
    private String nome;
    @DecimalMin("0.01")
    @DecimalMax("9999.00")
    private Double valor;
    @Min(value = 1, message = "Valor minimo uma peça!")
    @Max(value = 99, message = "valor excedito! ")
    private Integer quantidade;
    private String descricao;

}
