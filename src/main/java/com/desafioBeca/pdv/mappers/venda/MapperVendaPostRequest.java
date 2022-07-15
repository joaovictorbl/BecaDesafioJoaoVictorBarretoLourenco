package com.desafioBeca.pdv.mappers.venda;

import com.desafioBeca.pdv.dtos.requests.PostVendaRequest;
import com.desafioBeca.pdv.models.Venda;
import org.mapstruct.Mapper;

@Mapper
public interface MapperVendaPostRequest {

    public Venda toModel(PostVendaRequest postVendaRequest);
}
