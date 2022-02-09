package com.desafioBeca.pdv.mappers.produto;

import com.desafioBeca.pdv.dtos.requests.PatchProdutoRequest;
import com.desafioBeca.pdv.models.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperProdutoPatchRequest {

    public void atualizar(PatchProdutoRequest patchProdutoRequest, @MappingTarget Produto produto);
}
