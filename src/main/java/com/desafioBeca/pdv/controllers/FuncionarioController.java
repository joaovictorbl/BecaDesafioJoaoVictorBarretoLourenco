package com.desafioBeca.pdv.controllers;


import com.desafioBeca.pdv.dtos.requests.PostFuncionarioRequest;
import com.desafioBeca.pdv.dtos.responses.PostFuncionarioResponse;
import com.desafioBeca.pdv.models.Funcionario;
import com.desafioBeca.pdv.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/fucionario")
@RestController

public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<PostFuncionarioResponse> criar(@RequestBody PostFuncionarioRequest postFuncionarioRequest) {
        PostFuncionarioResponse funcionarioCriado = funcionarioService.criar(postFuncionarioRequest);
        return ResponseEntity.created(null).body(funcionarioCriado);

    }

     @GetMapping
    public ResponseEntity<List<Funcionario>> lista () {

        List<Funcionario> listaDeFuncionario = funcionarioService.lista();

        return ResponseEntity.ok(listaDeFuncionario);
     }

     @PatchMapping("/{id}")
     public ResponseEntity<Funcionario> atualizar (@RequestBody Funcionario funcionario, @PathVariable Integer id) {

        Funcionario funcionarioAtualizado = funcionarioService.atualizar(funcionario, id);

        return ResponseEntity.ok(funcionarioAtualizado);

     }

     @DeleteMapping("/{id}")
     public ResponseEntity<String> deletar (@PathVariable Integer id) {

        funcionarioService.deletar(id);

        return ResponseEntity.noContent().build();
     }

     @GetMapping("/{id}")
    public  ResponseEntity<Funcionario> obter (@PathVariable Integer id ) {

        Funcionario obterFuncionario = funcionarioService.obter(id);

         return ResponseEntity.ok(obterFuncionario);
     }

}
