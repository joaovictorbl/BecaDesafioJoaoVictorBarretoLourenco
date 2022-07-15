package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostClienteResquest {

    @NotBlank(message = "Campo Obrigatorio!")
    private String nome;
    private String cpf;
    @Size(min = 1, max = 8,message = "Caompo Obrigatorio!")
    private String telefone;
    private String logradouro;
    private Integer cep;

}
