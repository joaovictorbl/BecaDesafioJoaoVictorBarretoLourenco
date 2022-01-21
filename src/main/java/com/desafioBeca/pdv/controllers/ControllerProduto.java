package com.desafioBeca.pdv.controllers;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/produto")
@RestController
public class ControllerProduto {

    @PostMapping
    public void criar () {
        System.out.println("Adicionar");

    }

    @GetMapping
    public void lista () {
        System.out.println("listar Produtos");

    }

    @PatchMapping
    public void atualizar () {
        System.out.println("atualizar");

    }

    @DeleteMapping
    public void deletar () {
        System.out.println("deletar");

    }

    @GetMapping("/{id}")
    public void obter (@PathVariable Integer id) {
        System.out.println("pegar");

    }
}
