package com.desafioBeca.pdv.dtos.responses;

import lombok.*;

@Data
public class PatchProdutoResponse {

    private String nome;
    private Double valor;
    private Integer quantidade;
    private String descricao;

}
