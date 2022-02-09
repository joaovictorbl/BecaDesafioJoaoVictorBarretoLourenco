package com.desafioBeca.pdv.mappers.produto;

import com.desafioBeca.pdv.dtos.requests.PostProdutoRequest;
import com.desafioBeca.pdv.models.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoPostRequest {

    public Produto toModel(PostProdutoRequest postProdutoRequest);
}
