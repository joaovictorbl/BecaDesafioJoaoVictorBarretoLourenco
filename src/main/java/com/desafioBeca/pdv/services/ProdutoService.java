package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.ProdutoInterface;
import com.desafioBeca.pdv.models.Funcionario;
import com.desafioBeca.pdv.models.Produto;
import com.desafioBeca.pdv.repositories.FuncionarioRepository;
import com.desafioBeca.pdv.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements ProdutoInterface {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto criar(Produto produto) {

        Produto produtoNovo = produtoRepository.save(produto);
        return produtoNovo;
    }


    public List<Produto> lista() {

        List<Produto> listaProdutos = produtoRepository.findAll();
        return listaProdutos;
    }


    public Produto atualizar(Produto produto, Integer id) {

        Produto produtoObtido = this.obter(id);
        produtoObtido.setNome(produto.getNome());
        produtoObtido.setValor(produto.getValor());
        produtoObtido.setQuantidade(produto.getQuantidade());
        produtoObtido.setDescricao(produto.getDescricao());
        produtoRepository.save(produtoObtido);

        return produtoObtido;
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Produto obter(Integer id) {

        Produto produtoSelecao = produtoRepository.findById(id).get();

        if (produtoSelecao == null){
            throw new RuntimeException("Id funcionario não existe");
        }

        return produtoSelecao;
    }
}
