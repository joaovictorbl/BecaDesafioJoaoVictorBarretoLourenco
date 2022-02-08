package com.desafioBeca.pdv.controllers;


import com.desafioBeca.pdv.dtos.requests.PatchVendaRequest;
import com.desafioBeca.pdv.dtos.requests.PostVendaRequest;
import com.desafioBeca.pdv.dtos.responses.*;
import com.desafioBeca.pdv.models.Venda;
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
    public ResponseEntity<PostVendaResponse> criar(@RequestBody PostVendaRequest postVendaRequest) {
        PostVendaResponse criarVenda = vendaService.criar(postVendaRequest);
        return ResponseEntity.created(null).body(criarVenda);

    }

    @GetMapping
    public ResponseEntity<List<GetVendaListarResponse>> lista() {
        List<GetVendaListarResponse> listaDeVenda = vendaService.lista();
        return ResponseEntity.ok(listaDeVenda);

    }

    @PatchMapping("/{id}")
    public  ResponseEntity<PatchVendaResponse> atualizar(@RequestBody PatchVendaRequest vendaRequest, @PathVariable Integer id) {
        PatchVendaResponse vendaAtualizada = vendaService.atualizar(vendaRequest, id);
        return ResponseEntity.ok(vendaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable Integer id) {
        vendaService.deleta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetVendaObterResponse> obter(@PathVariable Integer id ) {
       GetVendaObterResponse obterVenda = vendaService.obter(id);
        return ResponseEntity.ok(obterVenda);

    }

}
