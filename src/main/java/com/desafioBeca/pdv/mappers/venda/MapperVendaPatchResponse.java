package com.desafioBeca.pdv.mappers.venda;

import com.desafioBeca.pdv.dtos.responses.PatchVendaResponse;
import com.desafioBeca.pdv.models.Venda;
import org.mapstruct.Mapper;

@Mapper
public interface MapperVendaPatchResponse {

    public PatchVendaResponse toResponse(Venda venda);
}
