package com.desafioBeca.pdv.services;


import com.desafioBeca.pdv.Interfaces.VendaInterface;
import com.desafioBeca.pdv.models.Produto;
import com.desafioBeca.pdv.models.Venda;;
import com.desafioBeca.pdv.repositories.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService implements VendaInterface {

    private final VendaRepository vendaRepository;

    private final ProdutoService produtoService;

    public Venda criar(Venda venda) {

        Produto produtoCriado = produtoService.obter(venda.getProduto().getId());
        venda.setProduto(produtoCriado);
        Venda novaVenda = vendaRepository.save(venda);

        return novaVenda;
    }

    public List<Venda> lista() {

        List<Venda> listaVenda = vendaRepository.findAll();
        return listaVenda;
    }

    public Venda atualizar(Venda venda, Integer id) {

        Venda vendaObtida = this.obter(id);
        vendaObtida.setValorFinal(venda.getValorFinal());
        vendaObtida.setQuantidadeFinal(venda.getQuantidadeFinal());
        Produto produtoObtido = produtoService.obter(venda.getProduto().getId());
        vendaObtida.setProduto(produtoObtido);

        return vendaObtida;
    }


    public void deleta(Integer id) {
        vendaRepository.deleteById(id);

    }

    public Venda obter(Integer id) {

        Venda vendaSelecao = vendaRepository.findById(id).get();

        if (vendaSelecao == null) {
            throw new RuntimeException("Id de venda não existe! ");
        }
        return vendaSelecao;

    }
}
