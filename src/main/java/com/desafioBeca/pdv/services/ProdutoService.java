package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    public Produto criar(Produto produto) {

        System.out.println(produto);

        produto.setId(1);

        System.out.println("nnvo produto");

        return produto;

    }


    public List<Produto> lista() {

        Produto pro1 = new Produto();
        pro1.setId(1);
        pro1.setNome("calça");

        Produto pro2 = new Produto();
        pro2.setId(2);
        pro2.setNome("camisa");

        return List.of(
                pro1,
                pro2
        );

    }


    public Produto atualizar(Produto produto, Integer id) {

        produto.setId(id);

        return produto;

    }


    public void deletar(Integer id) {


    }


    public Produto obter(Integer id) {

        Produto pro1 = new Produto();
        pro1.setId(id);
        pro1.setNome("bermuda");

        return pro1;

    }
}
