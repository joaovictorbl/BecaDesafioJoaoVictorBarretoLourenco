package com.desafioBeca.pdv.mappers.cliente;

import com.desafioBeca.pdv.dtos.responses.PatchClienteResponse;
import com.desafioBeca.pdv.models.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface MapperClientePatchResponse {

    public PatchClienteResponse toResponse(Cliente cliente);
}
