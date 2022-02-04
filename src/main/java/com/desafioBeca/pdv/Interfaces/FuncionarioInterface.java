package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.dtos.requests.PostFuncionarioRequest;
import com.desafioBeca.pdv.dtos.responses.PostFuncionarioResponse;
import com.desafioBeca.pdv.models.Funcionario;

import java.util.List;

public interface FuncionarioInterface {

    PostFuncionarioResponse criar(PostFuncionarioRequest postFuncionarioRequest);

    List<Funcionario> lista();

    Funcionario atualizar(Funcionario funcionario, Integer id);

    void deletar(Integer id);

    Funcionario obter(Integer id);

}
