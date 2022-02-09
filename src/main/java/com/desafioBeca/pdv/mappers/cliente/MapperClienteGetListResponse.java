package com.desafioBeca.pdv.mappers.cliente;

import com.desafioBeca.pdv.dtos.responses.GetClienteListarResponse;
import com.desafioBeca.pdv.models.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface MapperClienteGetListResponse {

    public GetClienteListarResponse toResponse(Cliente cliente);
}
