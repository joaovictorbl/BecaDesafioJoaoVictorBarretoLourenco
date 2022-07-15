package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PatchProdutoRequest {

    @NotBlank(message = "Campo Obrigatorio!")
    private String nome;
    @NotBlank(message = "Campo Obrigatorio!")
    private Double valor;
    @Size(min = 1, max = 8)
    private Integer quantidade;
    private String descricao;

}
