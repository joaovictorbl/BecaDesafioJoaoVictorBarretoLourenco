package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.dtos.requests.PatchClienteResquest;
import com.desafioBeca.pdv.dtos.requests.PostClienteResquest;
import com.desafioBeca.pdv.dtos.responses.GetClienteListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetClienteObterResponse;
import com.desafioBeca.pdv.dtos.responses.PatchClienteResponse;
import com.desafioBeca.pdv.dtos.responses.PostClienteResponse;
import com.desafioBeca.pdv.models.Cliente;

import java.util.List;

public interface

ClienteInterface {

    PostClienteResponse criar(PostClienteResquest postClienteResquest);

    List<GetClienteListarResponse> listar();

    void deletar(Integer id);

    PatchClienteResponse atualizar(PatchClienteResquest patchClienteResquest, Integer id);

    GetClienteObterResponse obter(Integer id);

}
