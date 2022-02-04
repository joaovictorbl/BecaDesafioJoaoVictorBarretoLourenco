package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.dtos.requests.PostProdutoRequest;
import com.desafioBeca.pdv.dtos.responses.PostProdutoReponse;
import com.desafioBeca.pdv.models.Produto;

import java.util.List;

public interface ProdutoInterface {

    PostProdutoReponse criar(PostProdutoRequest postProdutoRequest);

    List<Produto> lista();

    Produto atualizar(Produto produto, Integer id);

    void deletar(Integer id);

    Produto obter(Integer id);

}
