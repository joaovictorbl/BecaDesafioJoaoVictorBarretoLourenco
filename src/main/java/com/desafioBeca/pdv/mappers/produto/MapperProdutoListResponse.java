package com.desafioBeca.pdv.mappers.produto;

import com.desafioBeca.pdv.dtos.responses.GetProdutoListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetProdutoObterResponse;
import com.desafioBeca.pdv.models.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoListResponse {

    public GetProdutoListarResponse toResponse(Produto produto);
}
