package com.desafioBeca.pdv.mappers.venda;

import com.desafioBeca.pdv.dtos.responses.GetVendaObterResponse;
import com.desafioBeca.pdv.models.Venda;
import org.mapstruct.Mapper;

@Mapper
public interface MapperVendaObterResponse {

    public GetVendaObterResponse toResponse(Venda venda);
}
