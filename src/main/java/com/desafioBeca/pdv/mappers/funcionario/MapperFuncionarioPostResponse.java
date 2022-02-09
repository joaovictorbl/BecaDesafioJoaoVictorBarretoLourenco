package com.desafioBeca.pdv.mappers.funcionario;

import com.desafioBeca.pdv.dtos.responses.PostFuncionarioResponse;
import com.desafioBeca.pdv.models.Funcionario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperFuncionarioPostResponse {

    public PostFuncionarioResponse toResponse(Funcionario funcionario);
}
