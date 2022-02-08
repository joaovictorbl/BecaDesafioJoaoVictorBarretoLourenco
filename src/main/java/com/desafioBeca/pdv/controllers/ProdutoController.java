package com.desafioBeca.pdv.controllers;

import com.desafioBeca.pdv.dtos.requests.PatchProdutoRequest;
import com.desafioBeca.pdv.dtos.requests.PostFuncionarioRequest;
import com.desafioBeca.pdv.dtos.requests.PostProdutoRequest;
import com.desafioBeca.pdv.dtos.responses.GetProdutoListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetProdutoObterResponse;
import com.desafioBeca.pdv.dtos.responses.PatchProdutoResponse;
import com.desafioBeca.pdv.dtos.responses.PostProdutoReponse;
import com.desafioBeca.pdv.models.Produto;
import com.desafioBeca.pdv.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/produto")
@RestController

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<PostProdutoReponse> criar(@RequestBody PostProdutoRequest postProdutoRequest) {
        PostProdutoReponse produtoCriado = produtoService.criar(postProdutoRequest);
        return ResponseEntity.created(null).body(produtoCriado);

    }

    @GetMapping
    public ResponseEntity<List<GetProdutoListarResponse>> lista() {

        List<GetProdutoListarResponse> listaDeProdutos = produtoService.lista();
        return ResponseEntity.ok(listaDeProdutos);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchProdutoResponse> atualizar(@RequestBody PatchProdutoRequest produto, @PathVariable Integer id) {

        PatchProdutoResponse produtoAtualizado = produtoService.atualizar(produto, id);
        return ResponseEntity.ok(produtoAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {

        produtoService.deletar(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProdutoObterResponse> obter(@PathVariable Integer id) {
        GetProdutoObterResponse obterProduto = produtoService.obter(id);
        return ResponseEntity.ok(obterProduto);
    }
}
