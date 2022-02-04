package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.ClienteInterface;
import com.desafioBeca.pdv.dtos.requests.PostClienteResquest;
import com.desafioBeca.pdv.dtos.responses.PostClienteResponse;
import com.desafioBeca.pdv.models.Cliente;
import com.desafioBeca.pdv.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ClienteInterface {

    @Autowired
    private ClienteRepository clienteRepository;

    public PostClienteResponse criar(PostClienteResquest postClienteResquest) {

        Cliente clienteNovo = this.postClienteRequest(postClienteResquest);
        clienteRepository.save(clienteNovo);
        PostClienteResponse clienteRes = this.postClienteResponse(clienteNovo);
        return clienteRes;

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
        clienteObtido.setTelefone(cliente.getTelefone());
        clienteRepository.save(clienteObtido);

        return clienteObtido;

    }


    public void deletar(Integer id) {
        clienteRepository.deleteById(id);

    }


    public Cliente obter(Integer id) {

        Cliente clienteSelecao = clienteRepository.findById(id).get();

        if (clienteSelecao == null) {
            throw new RuntimeException("Id cliente não existe! ");
        }

        return clienteSelecao;
    }

    private Cliente postClienteRequest(PostClienteResquest postClienteResquest) {
        Cliente clientePost = new Cliente();
        clientePost.setNome(postClienteResquest.getNome());
        clientePost.setCpf(postClienteResquest.getCpf());
        clientePost.setTelefone(postClienteResquest.getTelefone());
        clientePost.setLogradouro(postClienteResquest.getLogradouro());
        clientePost.setCep(postClienteResquest.getCep());

        return clientePost;
    }

    private  PostClienteResponse postClienteResponse(Cliente cliente){
        PostClienteResponse clienteResponse = new PostClienteResponse();
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setTelefone(cliente.getTelefone());

        return clienteResponse;
    }
}
