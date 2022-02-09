package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

@Data
public class PostFuncionarioRequest {

    private String nome;
    private String cpf;
    private Integer telefone;
    private String logradouro;
    private Integer cep;
}
