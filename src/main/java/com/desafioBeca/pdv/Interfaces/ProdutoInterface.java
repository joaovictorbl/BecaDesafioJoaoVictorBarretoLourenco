package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.models.Produto;

import java.util.List;

public interface ProdutoInterface {

    Produto criar(Produto produto);

    List<Produto> lista();

    Produto atualizar(Produto produto, Integer id);

    void deletar(Integer id);

    Produto obter(Integer id);

}
