package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

@Data
public class PatchFuncionarioRequest {

    private String nome;
    private String cpf;
    private Integer telefone;
    private String logradouro;
    private Integer cep;

}
