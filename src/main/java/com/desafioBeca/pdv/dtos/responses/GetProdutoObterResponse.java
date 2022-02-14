package com.desafioBeca.pdv.dtos.responses;

import lombok.*;

@Data
public class GetProdutoObterResponse {

    private Integer id;
    private String nome;
    private Double valor;
    private Integer quantidade;
    private String descricao;

}
