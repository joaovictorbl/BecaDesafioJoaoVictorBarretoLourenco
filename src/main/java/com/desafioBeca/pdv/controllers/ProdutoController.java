package com.desafioBeca.pdv.controllers;

import com.desafioBeca.pdv.model.Funcionario;
import com.desafioBeca.pdv.model.Produto;
import com.desafioBeca.pdv.services.FuncionarioService;
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
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {

        Produto produtoCriado = produtoService.criar(produto);

        return ResponseEntity.created(null).body(produtoCriado);

    }

    @GetMapping
    public ResponseEntity<List<Produto>> lista() {

        List listaDeProdutos = produtoService.lista();

        return ResponseEntity.ok(listaDeProdutos);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Integer id) {

        Produto produtoAtualizado = produtoService.atualizar(produto, id);

        return ResponseEntity.ok(produtoAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {

        produtoService.deletar(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obter(@PathVariable Integer id) {

        Produto obterProduto = produtoService.obter(id);

        return ResponseEntity.ok(obterProduto);

    }
}
