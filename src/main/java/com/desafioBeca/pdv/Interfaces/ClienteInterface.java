package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.models.Cliente;

import java.util.List;

public interface ClienteInterface {

    Cliente criar(Cliente cliente);

    List<Cliente> listar();

    void deletar(Integer id);

    Cliente atualizar(Cliente cliente, Integer id);

    Cliente obter(Integer id);

}
