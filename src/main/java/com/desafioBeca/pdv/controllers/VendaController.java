package com.desafioBeca.pdv.controllers;


import com.desafioBeca.pdv.model.Venda;
import com.desafioBeca.pdv.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/venda")
@RestController

public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> criar(@RequestBody Venda venda ) {

        Venda criarVenda = vendaService.criar(venda);

        return ResponseEntity.created(null).body(criarVenda);

    }

    @GetMapping
    public ResponseEntity<List<Venda>> lista() {

        List listaDeVenda = vendaService.lista();

        return ResponseEntity.ok(listaDeVenda);

    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Venda> atualizar(@RequestBody Venda venda, @PathVariable Integer id) {

        Venda vendaAtualizada = vendaService.atualizar(venda, id);

        return ResponseEntity.ok(vendaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable Integer id) {

        vendaService.deleta(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> obter(@PathVariable Integer id ) {

       Venda obterVenda = vendaService.obter(id);

        return ResponseEntity.ok(obterVenda);

    }
}
