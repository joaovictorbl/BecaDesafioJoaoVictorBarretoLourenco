package com.desafioBeca.pdv.mappers.cliente;

import com.desafioBeca.pdv.dtos.requests.PostClienteResquest;
import com.desafioBeca.pdv.models.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface MapperClientePostRequest {

    public Cliente toModel(PostClienteResquest postClienteResquest);
}
