package com.desafioBeca.pdv.mappers.venda;

import com.desafioBeca.pdv.dtos.requests.PatchVendaRequest;
import com.desafioBeca.pdv.models.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperVendaPatchRequest {

    public void atualizar(PatchVendaRequest patchVendaRequest, @MappingTarget Venda venda);
}
