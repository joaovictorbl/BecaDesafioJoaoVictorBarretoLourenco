package com.desafioBeca.pdv.mappers.venda;

import com.desafioBeca.pdv.dtos.responses.GetVendaListarResponse;
import com.desafioBeca.pdv.models.Venda;
import org.mapstruct.Mapper;

@Mapper
public interface MapperVendaListRespponse {

    public GetVendaListarResponse toReponse(Venda venda);
}
