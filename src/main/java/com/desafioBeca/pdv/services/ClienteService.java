package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.ClienteInterface;
import com.desafioBeca.pdv.dtos.requests.PatchClienteResquest;
import com.desafioBeca.pdv.dtos.requests.PostClienteResquest;
import com.desafioBeca.pdv.dtos.responses.GetClienteListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetClienteObterResponse;
import com.desafioBeca.pdv.dtos.responses.PatchClienteResponse;
import com.desafioBeca.pdv.dtos.responses.PostClienteResponse;
import com.desafioBeca.pdv.models.Cliente;
import com.desafioBeca.pdv.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<GetClienteListarResponse> listar() {

        List<Cliente> listaCliente = clienteRepository.findAll();

        return listaCliente.stream().map(
                cliente -> this.converter(cliente)
        ).collect(Collectors.toList());
    }

    public PatchClienteResponse atualizar(PatchClienteResquest patchClienteResquest, Integer id) {

        Cliente clienteObtido = clienteRepository.findById(id).get();
        clienteObtido = this.patchClienteRequest(patchClienteResquest);
        clienteRepository.save(clienteObtido);


        return this.patchClienteResponse(clienteObtido);

    }


    public void deletar(Integer id) {
        clienteRepository.deleteById(id);

    }


    public GetClienteObterResponse obter(Integer id) {

        Cliente clienteSelecao = clienteRepository.findById(id).get();

        if (clienteSelecao == null) {
            throw new RuntimeException("Id cliente não existe! ");
        }

        return this.getClienteObterResponse(clienteSelecao);
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

    private GetClienteObterResponse getClienteObterResponse (Cliente cliente) {
        GetClienteObterResponse clienteGet = new GetClienteObterResponse();
        clienteGet.setNome(cliente.getNome());
        clienteGet.setCpf(cliente.getCpf());
        clienteGet.setTelefone(cliente.getTelefone());
        clienteGet.setCep(cliente.getCep());
        clienteGet.setLogradouro(cliente.getLogradouro());

        return clienteGet;
    }

    private Cliente patchClienteRequest (PatchClienteResquest patchClienteResquest) {
        Cliente clienteAtualizar = new Cliente();
        clienteAtualizar.setNome(patchClienteResquest.getNome());
        clienteAtualizar.setCpf(patchClienteResquest.getCpf());
        clienteAtualizar.setTelefone(patchClienteResquest.getTelefone());
        clienteAtualizar.setCep(patchClienteResquest.getCep());
        clienteAtualizar.setLogradouro(patchClienteResquest.getLogradouro());

        return clienteAtualizar;
    }

    private PatchClienteResponse patchClienteResponse (Cliente cliente) {
        PatchClienteResponse clientePatch = new PatchClienteResponse();
        clientePatch.setNome(cliente.getNome());
        clientePatch.setCpf(cliente.getCpf());
        clientePatch.setTelefone(cliente.getTelefone());
        clientePatch.setCep(cliente.getCep());
        clientePatch.setLogradouro(cliente.getLogradouro());

        return clientePatch;
    }

    private GetClienteListarResponse converter(Cliente cliente) {
        GetClienteListarResponse clienteListar = new GetClienteListarResponse();
        clienteListar.setId(cliente.getId());
        clienteListar.setNome(cliente.getNome());

        return clienteListar;

    }

}
