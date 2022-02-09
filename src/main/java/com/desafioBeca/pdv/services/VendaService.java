package com.desafioBeca.pdv.services;


import com.desafioBeca.pdv.Interfaces.VendaInterface;
import com.desafioBeca.pdv.dtos.requests.PatchVendaRequest;
import com.desafioBeca.pdv.dtos.requests.PostVendaRequest;
import com.desafioBeca.pdv.dtos.responses.*;
import com.desafioBeca.pdv.mappers.produto.MapperProdutoPostResponse;
import com.desafioBeca.pdv.mappers.venda.*;
import com.desafioBeca.pdv.models.Produto;
import com.desafioBeca.pdv.models.Venda;;
import com.desafioBeca.pdv.repositories.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendaService implements VendaInterface {

    private final ProdutoService produtoService;

    private final VendaRepository vendaRepository;
    private final MapperVendaListRespponse mapperVendaListRespponse;
    private final MapperVendaObterResponse mapperVendaObterResponse;
    private final MapperVendaPatchRequest mapperVendaPatchRequest;
    private final MapperVendaPatchResponse mapperVendaPatchResponse;
    private final MapperVendaPostRequest mapperVendaPostRequest;
    private final MapperVendaPostResponse mapperVendaPostResponse;

    public PostVendaResponse criar(PostVendaRequest postVendaRequest) {

        Venda novaVenda = mapperVendaPostRequest.toModel(postVendaRequest);
        vendaRepository.save(novaVenda);
        return mapperVendaPostResponse.toResponse(novaVenda);
    }

    public List<GetVendaListarResponse> lista() {

        List<Venda> listaVenda = vendaRepository.findAll();
        return listaVenda.stream().map(mapperVendaListRespponse::toReponse).collect(Collectors.toList());
    }

    public PatchVendaResponse atualizar(PatchVendaRequest patchVendaRequest, Integer id) {

        Venda vendaObtida = vendaRepository.findById(id).get();
        mapperVendaPatchRequest.atualizar(patchVendaRequest, vendaObtida);
        vendaRepository.save(vendaObtida);

        return mapperVendaPatchResponse.toResponse(vendaObtida);
    }


    public void deleta(Integer id) {
        vendaRepository.deleteById(id);

    }

    public GetVendaObterResponse obter(Integer id) {

        Venda vendaSelecao = vendaRepository.findById(id).get();

        if (vendaSelecao == null) {
            throw new RuntimeException("Id de venda não existe! ");
        }
        return mapperVendaObterResponse.toResponse(vendaSelecao);
    }
}
