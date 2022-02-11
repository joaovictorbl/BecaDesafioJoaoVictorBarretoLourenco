package com.desafioBeca.pdv.dtos.requests;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PatchClienteResquest {

    @NotBlank(message = "Caompo Obrigatorio!")
    private String nome;
    @Size(max = 12)
    private String cpf;
    @Size(min = 1, max = 8,message = "Caompo Obrigatorio!")
    private String telefone;
    private String logradouro;
    private Integer cep;
}
