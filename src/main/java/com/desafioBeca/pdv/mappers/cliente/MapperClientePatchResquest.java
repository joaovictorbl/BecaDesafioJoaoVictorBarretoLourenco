package com.desafioBeca.pdv.mappers.cliente;

import com.desafioBeca.pdv.dtos.requests.PatchClienteResquest;
import com.desafioBeca.pdv.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperClientePatchResquest {

    public void atualizar(PatchClienteResquest patchClienteResquest, @MappingTarget Cliente cliente);
}
