package com.desafioBeca.pdv.models;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Pessoa {

   private String nome;
   private String cpf;
   private String telefone;
   private String logradouro;
   private Integer cep;

}
