package com.desafioBeca.pdv.mappers.funcionario;

import com.desafioBeca.pdv.dtos.requests.PostFuncionarioRequest;
import com.desafioBeca.pdv.models.Funcionario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperFuncionarioPostRequest {

    public Funcionario toModel(PostFuncionarioRequest postFuncionarioRequest);
}
