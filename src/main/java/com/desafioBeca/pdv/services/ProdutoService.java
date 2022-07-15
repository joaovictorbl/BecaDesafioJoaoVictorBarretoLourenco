package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.ProdutoInterface;
import com.desafioBeca.pdv.dtos.requests.PatchProdutoRequest;
import com.desafioBeca.pdv.dtos.requests.PostProdutoRequest;
import com.desafioBeca.pdv.dtos.responses.*;
import com.desafioBeca.pdv.mappers.produto.*;
import com.desafioBeca.pdv.models.Produto;
import com.desafioBeca.pdv.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService implements ProdutoInterface {


    private final ProdutoRepository produtoRepository;
    private final MapperProdutoListResponse mapperProdutoListResponse;
    private final MapperProdutoObterResponse mapperProdutoObterresponse;
    private final MapperProdutoPatchRequest mapperProdutoPatchRequest;
    private final MapperProdutoPatchResponse mapperProdutoPatchResponse;
    private final MapperProdutoPostRequest mapperProdutoPostRequest;
    private final MapperProdutoPostResponse mapperProdutoPostResponse;


    public PostProdutoReponse criar(PostProdutoRequest postProdutoRequest) {

        Produto produtoNovo = mapperProdutoPostRequest.toModel(postProdutoRequest);
        produtoRepository.save(produtoNovo);
        return mapperProdutoPostResponse.toResponse(produtoNovo);
    }

    public List<GetProdutoListarResponse> lista() {

        List<Produto> listaProdutos = produtoRepository.findAll();
        return listaProdutos.stream().map(mapperProdutoListResponse::toResponse).collect(Collectors.toList());
    }


    public PatchProdutoResponse atualizar(PatchProdutoRequest patchProdutoRequest, Integer id) {

        Produto produtoObtido = produtoRepository.findById(id).get();
        mapperProdutoPatchRequest.atualizar(patchProdutoRequest, produtoObtido);
                produtoRepository.save(produtoObtido);

        return mapperProdutoPatchResponse.toResponse(produtoObtido);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);

    }

    public GetProdutoObterResponse obter(Integer id) {

        Produto produtoSelecao = produtoRepository.findById(id).get();

        if (produtoSelecao == null){
            throw new RuntimeException("Id funcionario não existe");
        }

        return mapperProdutoObterresponse.toResponse(produtoSelecao);
    }
}
