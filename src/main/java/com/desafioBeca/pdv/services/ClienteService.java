package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    public Cliente criar (Cliente cliente) {

        System.out.println(cliente);

        cliente.setId(1);

        System.out.println("novo cliente");

        return cliente;

    }

    public List<Cliente> listar () {

        Cliente cli1 = new Cliente();
        cli1.setId(1);
        cli1.setNome("fulano");

        Cliente cli2 = new Cliente();
        cli2.setId(2);
        cli2.setNome("Alguém ");

        Cliente cli3 = new Cliente();
        cli3.setId(3);
        cli3.setNome("bla bla bla");

        return List.of(
                cli1,
                cli2,
                cli3
        );
    }

    public Cliente atualizar (Cliente cliente, Integer id) {

        cliente.setId(id);

        return cliente;

    }


    public void deletar (Integer id) {


    }


    public Cliente  obter (Integer id) {

        Cliente cli1 = new Cliente();
        cli1.setId(id);
        cli1.setNome("joão");

        return cli1;
    }
}
