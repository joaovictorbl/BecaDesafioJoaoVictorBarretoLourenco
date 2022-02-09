package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

@Data
public class PatchProdutoRequest {

    private String nome;
    private Double valor;
    private Integer quantidade;
    private String descricao;

}
