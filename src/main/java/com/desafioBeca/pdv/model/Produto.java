package com.desafioBeca.pdv.model;

public class Produto {

   private Integer id;
   private String nome;
   private Double valor;
   private Integer quantidade;
   private String descricao;

   public Produto() {
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Double getValor() {
      return valor;
   }

   public void setValor(Double valor) {
      this.valor = valor;
   }

   public Integer getQuantidade() {
      return quantidade;
   }

   public void setQuantidade(Integer quantidade) {
      this.quantidade = quantidade;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }
}
