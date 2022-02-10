package com.desafioBeca.pdv.dtos.responses;

import lombok.*;

@Data
public class GetClienteObterResponse {

    private String nome;
    private String cpf;
    private String telefone;
    private String logradouro;
    private Integer cep;

}
