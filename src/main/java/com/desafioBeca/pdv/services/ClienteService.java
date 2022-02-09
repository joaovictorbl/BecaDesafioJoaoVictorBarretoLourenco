package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.ClienteInterface;
import com.desafioBeca.pdv.dtos.requests.PatchClienteResquest;
import com.desafioBeca.pdv.dtos.requests.PostClienteResquest;
import com.desafioBeca.pdv.dtos.responses.GetClienteListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetClienteObterResponse;
import com.desafioBeca.pdv.dtos.responses.PatchClienteResponse;
import com.desafioBeca.pdv.dtos.responses.PostClienteResponse;
import com.desafioBeca.pdv.mappers.cliente.*;
import com.desafioBeca.pdv.models.Cliente;
import com.desafioBeca.pdv.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService implements ClienteInterface {


    private final ClienteRepository clienteRepository;
    private final MapperClienteGetListResponse mapperClienteGetListResponse;
    private final MapperClienteGetObterResponse mapperClienteGetObterResponse;
    private final MapperClientePatchResponse mapperClientePatchResponse;
    private final MapperClientePatchResquest mapperClientePatchResquest;
    private final MapperClientePostRequest mapperClientePostRequest;
    private final MapperClientePostResponse mapperClientePostResponse;

    public PostClienteResponse criar(PostClienteResquest postClienteResquest) {

        Cliente clienteNovo = mapperClientePostRequest.toModel(postClienteResquest);
        clienteRepository.save(clienteNovo);
        return mapperClientePostResponse.toResponse(clienteNovo);

    }

    public List<GetClienteListarResponse> listar() {

        List<Cliente> listaCliente = clienteRepository.findAll();
        return listaCliente.stream().map(
                cliente -> mapperClienteGetListResponse.toResponse(cliente)
        ).collect(Collectors.toList());
    }

    public PatchClienteResponse atualizar(PatchClienteResquest patchClienteResquest, Integer id) {

        Cliente clienteObtido = clienteRepository.findById(id).get();
        mapperClientePatchResquest.atualizar(patchClienteResquest, clienteObtido);
        clienteRepository.save(clienteObtido);

        return mapperClientePatchResponse.toResponse(clienteObtido);

    }


    public void deletar(Integer id) {
        clienteRepository.deleteById(id);

    }


    public GetClienteObterResponse obter(Integer id) {

        Cliente clienteSelecao = clienteRepository.findById(id).get();

        if (clienteSelecao == null) {
            throw new RuntimeException("Id cliente não existe! ");
        }

        return mapperClienteGetObterResponse.toResponse(clienteSelecao);
    }
}
