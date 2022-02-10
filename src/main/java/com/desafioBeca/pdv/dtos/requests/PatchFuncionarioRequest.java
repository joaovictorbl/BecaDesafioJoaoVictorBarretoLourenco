package com.desafioBeca.pdv.dtos.requests;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PatchFuncionarioRequest {

    @NotBlank(message = "Campo Obrigatorio!")
    private String nome;
    @NotBlank(message = "Campo Obrigatorio!")
    private String cpf;
    @Size(min = 1, max = 8,message = "Caompo Obrigatorio!")
    private String telefone;
    @NotBlank(message = "Campo Obrigatorio!")
    private String logradouro;
    @NotBlank(message = "Campo Obrigatorio!")
    private Integer cep;

}
