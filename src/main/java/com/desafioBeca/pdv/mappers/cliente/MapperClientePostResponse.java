package com.desafioBeca.pdv.mappers.cliente;

import com.desafioBeca.pdv.dtos.responses.PostClienteResponse;
import com.desafioBeca.pdv.models.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface MapperClientePostResponse {

    public PostClienteResponse toResponse(Cliente cliente);
}
