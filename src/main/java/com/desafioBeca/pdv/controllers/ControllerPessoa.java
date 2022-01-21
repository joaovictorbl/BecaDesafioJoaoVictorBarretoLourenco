package com.desafioBeca.pdv.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class ControllerPessoa {

    @PostMapping
    public void criar () {

    }

    @GetMapping
    public void lista () {

    }

    @DeleteMapping
    public void deletar() {

    }

    @GetMapping("/{id}")
    public void obter (@PathVariable Integer id) {

    }

}