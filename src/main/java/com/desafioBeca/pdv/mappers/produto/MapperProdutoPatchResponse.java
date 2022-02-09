package com.desafioBeca.pdv.mappers.produto;

import com.desafioBeca.pdv.dtos.requests.PatchProdutoRequest;
import com.desafioBeca.pdv.dtos.responses.PatchProdutoResponse;
import com.desafioBeca.pdv.models.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoPatchResponse {

    public PatchProdutoResponse toResponse(Produto produto);
}
