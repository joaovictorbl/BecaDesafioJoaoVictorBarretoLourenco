package com.desafioBeca.pdv.mappers.venda;

import com.desafioBeca.pdv.dtos.responses.PostVendaResponse;
import com.desafioBeca.pdv.models.Venda;
import org.mapstruct.Mapper;

@Mapper
public interface MapperVendaPostResponse {

    public PostVendaResponse toResponse(Venda venda);
}
