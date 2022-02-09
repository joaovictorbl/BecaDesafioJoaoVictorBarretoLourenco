package com.desafioBeca.pdv.mappers.funcionario;

import com.desafioBeca.pdv.dtos.responses.PatchFuncionarioResponse;
import com.desafioBeca.pdv.models.Funcionario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperFuncionarioPatchResponse {

    public PatchFuncionarioResponse toReponse(Funcionario funcionario);
}
