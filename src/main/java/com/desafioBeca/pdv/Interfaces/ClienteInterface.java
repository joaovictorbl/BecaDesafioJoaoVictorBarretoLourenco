package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.dtos.requests.PostClienteResquest;
import com.desafioBeca.pdv.dtos.responses.PostClienteResponse;
import com.desafioBeca.pdv.models.Cliente;

import java.util.List;

public interface

ClienteInterface {

    PostClienteResponse criar(PostClienteResquest postClienteResquest);

    List<Cliente> listar();

    void deletar(Integer id);

    Cliente atualizar(Cliente cliente, Integer id);

    Cliente obter(Integer id);

}
