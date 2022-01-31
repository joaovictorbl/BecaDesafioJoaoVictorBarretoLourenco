package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.models.Venda;

import java.util.List;

public interface VendaInterface {

    Venda criar(Venda venda);

    List<Venda> lista();

    Venda atualizar(Venda venda, Integer id);

    void deleta(Integer id);

    Venda obter(Integer id);
}
