package com.desafioBeca.pdv.dtos.requests;

import lombok.Data;

@Data
public class PatchFuncionarioRequest {

    private String nome;
    private String cpf;
    private String telefone;
    private String logradouro;
    private Integer cep;

}
