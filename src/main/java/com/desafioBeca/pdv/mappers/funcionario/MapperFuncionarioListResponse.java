package com.desafioBeca.pdv.mappers.funcionario;

import com.desafioBeca.pdv.dtos.responses.GetFuncionarioListarResponse;
import com.desafioBeca.pdv.models.Funcionario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperFuncionarioListResponse {

    public GetFuncionarioListarResponse toResponse(Funcionario funcionario);
}
