package com.desafioBeca.pdv.mappers.cliente;

import com.desafioBeca.pdv.dtos.responses.GetClienteObterResponse;
import com.desafioBeca.pdv.models.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface MapperClienteGetObterResponse {

    public GetClienteObterResponse toResponse(Cliente cliente);
}
