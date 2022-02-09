package com.desafioBeca.pdv.mappers.funcionario;

import com.desafioBeca.pdv.dtos.requests.PatchFuncionarioRequest;
import com.desafioBeca.pdv.models.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperFuncionarioPatchRequest {

    public void atualizar(PatchFuncionarioRequest patchFuncionarioRequest, @MappingTarget Funcionario funcionario);
}
