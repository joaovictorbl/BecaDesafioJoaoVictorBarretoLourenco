package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PatchFuncionarioRequest {

    private String nome;
    private String cpf;
    private String telefone;
    private String logradouro;
    private Integer cep;

}
