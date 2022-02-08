package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.dtos.requests.PatchProdutoRequest;
import com.desafioBeca.pdv.dtos.requests.PostProdutoRequest;
import com.desafioBeca.pdv.dtos.responses.GetProdutoListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetProdutoObterResponse;
import com.desafioBeca.pdv.dtos.responses.PatchProdutoResponse;
import com.desafioBeca.pdv.dtos.responses.PostProdutoReponse;
import com.desafioBeca.pdv.models.Produto;

import java.util.List;

public interface ProdutoInterface {

    PostProdutoReponse criar(PostProdutoRequest postProdutoRequest);

    List<GetProdutoListarResponse> lista();

    PatchProdutoResponse atualizar(PatchProdutoRequest patchProdutoRequest, Integer id);

    void deletar(Integer id);

    GetProdutoObterResponse obter(Integer id);

}
