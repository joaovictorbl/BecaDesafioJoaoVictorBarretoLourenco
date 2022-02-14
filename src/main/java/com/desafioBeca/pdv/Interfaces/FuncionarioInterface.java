package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.dtos.requests.PatchFuncionarioRequest;
import com.desafioBeca.pdv.dtos.requests.PostFuncionarioRequest;
import com.desafioBeca.pdv.dtos.responses.GetFuncionarioListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetFuncionarioObterResponse;
import com.desafioBeca.pdv.dtos.responses.PatchFuncionarioResponse;
import com.desafioBeca.pdv.dtos.responses.PostFuncionarioResponse;

import java.util.List;

public interface FuncionarioInterface {

    PostFuncionarioResponse criar(PostFuncionarioRequest postFuncionarioRequest);

    List<GetFuncionarioListarResponse> lista();

    PatchFuncionarioResponse atualizar(PatchFuncionarioRequest patchFuncionarioRequest, Integer id);

    void deletar(Integer id);

    GetFuncionarioObterResponse obter(Integer id);

}
