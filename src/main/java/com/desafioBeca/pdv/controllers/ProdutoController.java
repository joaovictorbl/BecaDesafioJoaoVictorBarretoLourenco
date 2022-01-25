package com.desafioBeca.pdv.controllers;

import com.desafioBeca.pdv.model.Cliente;
import com.desafioBeca.pdv.model.Fucionario;
import com.desafioBeca.pdv.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintStream;
import java.util.List;

@RequestMapping("/produto")
@RestController

public class ProdutoController {

    @PostMapping
    public ResponseEntity<Produto> criar (@RequestBody Produto produto) {
        System.out.println(produto);

        produto.setId(1);

        System.out.println("nnvo produto");

        return ResponseEntity.created(null).body(produto);

    }

    @GetMapping
    public ResponseEntity<List<Produto>> lista () {

        Produto pro1 = new Produto();
        pro1.setId(1);
        pro1.setNome("calça");

        Produto pro2 = new Produto();
        pro2.setId(2);
        pro2.setNome("camisa");

        return ResponseEntity.ok(List.of( pro1,
                pro2
        ));

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizar (@RequestBody Produto produto, @PathVariable Integer id) {

        produto.setId(id);

        return ResponseEntity.ok(produto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable Integer id) {

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obter (@PathVariable Integer id) {

        Produto pro1 = new Produto();
        pro1.setId(id);
        pro1.setNome("bermuda");

        return ResponseEntity.ok(pro1);

    }
}
