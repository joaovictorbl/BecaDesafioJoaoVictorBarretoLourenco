package com.desafioBeca.pdv.mappers.funcionario;

import com.desafioBeca.pdv.dtos.responses.GetFuncionarioObterResponse;
import com.desafioBeca.pdv.models.Funcionario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperFuncionarioGetResponse {

    public GetFuncionarioObterResponse toResponse(Funcionario funcionario);
}
