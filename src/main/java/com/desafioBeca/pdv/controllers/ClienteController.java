package com.desafioBeca.pdv.controllers;

import com.desafioBeca.pdv.dtos.requests.PostClienteResquest;
import com.desafioBeca.pdv.dtos.responses.PostClienteResponse;
import com.desafioBeca.pdv.models.Cliente;
import com.desafioBeca.pdv.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cliente")
@RestController

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<PostClienteResponse> criar (@RequestBody PostClienteResquest postClienteResquest) {

        PostClienteResponse clienteCriado = clienteService.criar(postClienteResquest);

        return ResponseEntity.created(null).body(clienteCriado);

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar () {

       List<Cliente> listaDeCliente = clienteService.listar();

        return ResponseEntity.ok(listaDeCliente);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizar (@RequestBody Cliente cliente, @PathVariable Integer id) {

      Cliente clienteAtualizado = clienteService.atualizar(cliente, id);

      return ResponseEntity.ok(clienteAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable Integer id) {

        clienteService.deletar(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente>  obter (@PathVariable Integer id) {

        Cliente obterCliente = clienteService.obter(id);

        return ResponseEntity.ok(obterCliente);
    }
}
