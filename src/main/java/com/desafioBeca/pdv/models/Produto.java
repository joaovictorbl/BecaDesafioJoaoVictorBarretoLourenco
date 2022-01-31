package com.desafioBeca.pdv.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Produto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nome;
   private Double valor;
   private Integer quantidade;
   private String descricao;

}
