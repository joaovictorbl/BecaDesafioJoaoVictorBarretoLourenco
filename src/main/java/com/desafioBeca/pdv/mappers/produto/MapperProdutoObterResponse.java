package com.desafioBeca.pdv.mappers.produto;

import com.desafioBeca.pdv.dtos.responses.GetProdutoObterResponse;
import com.desafioBeca.pdv.models.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoObterResponse {

    public GetProdutoObterResponse toResponse(Produto produto);
}
