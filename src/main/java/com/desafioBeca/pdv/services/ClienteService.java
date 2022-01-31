package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.ClienteInterface;
import com.desafioBeca.pdv.models.Cliente;
import com.desafioBeca.pdv.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ClienteInterface {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente) {

        Cliente clienteNovo = clienteRepository.save(cliente);

        return clienteNovo;

    }

    public List<Cliente> listar() {

        List<Cliente> listaCliente = clienteRepository.findAll();

        return listaCliente;
    }

    public Cliente atualizar(Cliente cliente, Integer id) {

        Cliente clienteObtido = this.obter(id);
        clienteObtido.setNome(cliente.getNome());
        clienteObtido.setCep(cliente.getCep());
        clienteObtido.setCpf(cliente.getCpf());
        clienteObtido.setLogradouro(cliente.getLogradouro());
        clienteObtido.setNumero(cliente.getNumero());
        clienteRepository.save(clienteObtido);

        return clienteObtido;

    }


    public void deletar(Integer id) {
        clienteRepository.deleteById(id);

    }


    public Cliente obter(Integer id) {

        Cliente clienteSelecao = clienteRepository.findById(id).get();

        if (clienteSelecao == null){
            throw new RuntimeException("Id cliente não existe! ");
        }

        return clienteSelecao;
    }
}
