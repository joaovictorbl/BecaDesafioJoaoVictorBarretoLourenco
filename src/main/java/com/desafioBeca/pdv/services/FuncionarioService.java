package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.FuncionarioInterface;
import com.desafioBeca.pdv.dtos.requests.PatchClienteResquest;
import com.desafioBeca.pdv.dtos.requests.PatchFuncionarioRequest;
import com.desafioBeca.pdv.dtos.requests.PostFuncionarioRequest;
import com.desafioBeca.pdv.dtos.responses.*;
import com.desafioBeca.pdv.mappers.funcionario.*;
import com.desafioBeca.pdv.models.Funcionario;
import com.desafioBeca.pdv.repositories.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService implements FuncionarioInterface {


    private final FuncionarioRepository funcionarioRepository;
    private final MapperFuncionarioGetResponse mapperFuncionarioGetResponse;
    private final MapperFuncionarioListResponse mapperFuncionarioListResponse;
    private final MapperFuncionarioPatchRequest mapperFuncionarioPatchRequest;
    private final MapperFuncionarioPatchResponse mapperFuncionarioPatchResponse;
    private final MapperFuncionarioPostRequest mapperFuncionarioPostRequest;
    private final MapperFuncionarioPostResponse mapperFuncionarioPostResponse;


    public PostFuncionarioResponse criar(PostFuncionarioRequest postFuncionarioRequest) {

        Funcionario funcionarioNovo = mapperFuncionarioPostRequest.toModel(postFuncionarioRequest);
        funcionarioRepository.save(funcionarioNovo);
        return mapperFuncionarioPostResponse.toResponse(funcionarioNovo);
    }


    public List<GetFuncionarioListarResponse> lista() {

        List<Funcionario> listaFuncionario = funcionarioRepository.findAll();
        return listaFuncionario.stream().map(mapperFuncionarioListResponse::toResponse).collect(Collectors.toList());
    }

    public PatchFuncionarioResponse atualizar(PatchFuncionarioRequest patchFuncionarioRequest, Integer id) {

        Funcionario funcionarioObtido = funcionarioRepository.findById(id).get();
        mapperFuncionarioPatchRequest.atualizar(patchFuncionarioRequest, funcionarioObtido);
        funcionarioRepository.save(funcionarioObtido);

        return mapperFuncionarioPatchResponse.toReponse(funcionarioObtido);
    }


    public void deletar(Integer id) {
        funcionarioRepository.deleteById(id);

    }


    public GetFuncionarioObterResponse obter(Integer id) {

        Funcionario funcionario = funcionarioRepository.findById(id).get();

        if (funcionario == null) {
            throw new RuntimeException("Id funcionario não existe! ");
        }
        return mapperFuncionarioGetResponse.toResponse(funcionario);
    }
}
