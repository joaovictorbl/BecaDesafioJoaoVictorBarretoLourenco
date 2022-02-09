package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

@Data
public class PostProdutoRequest {

    private String nome;
    private Double valor;
    private Integer quantidade;
    private String descricao;

}
