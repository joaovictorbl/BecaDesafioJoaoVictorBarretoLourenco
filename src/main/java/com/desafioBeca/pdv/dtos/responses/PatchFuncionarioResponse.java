package com.desafioBeca.pdv.dtos.responses;

import lombok.Data;

@Data
public class PatchFuncionarioResponse {

    private String nome;
    private String cpf;
    private Integer telefone;
    private String logradouro;
    private Integer cep;

}
