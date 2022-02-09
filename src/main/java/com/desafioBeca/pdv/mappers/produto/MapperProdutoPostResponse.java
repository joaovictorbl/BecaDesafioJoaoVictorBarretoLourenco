package com.desafioBeca.pdv.mappers.produto;

import com.desafioBeca.pdv.dtos.responses.PostProdutoReponse;
import com.desafioBeca.pdv.models.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoPostResponse {

    public PostProdutoReponse toResponse(Produto produto);
}
