package com.desafioBeca.pdv.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valorFinal;
    private Integer quantidadeFinal;

    @ManyToOne      // many = são varios produtod / one é equivalente a uma venda
    private Produto produto;
}
