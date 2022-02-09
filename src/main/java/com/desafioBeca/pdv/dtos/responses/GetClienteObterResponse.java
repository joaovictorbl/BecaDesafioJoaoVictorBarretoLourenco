package com.desafioBeca.pdv.dtos.responses;

import lombok.*;

@Data
public class GetClienteObterResponse {

    private String nome;
    private String cpf;
    private Integer telefone;
    private String logradouro;
    private Integer cep;

}
