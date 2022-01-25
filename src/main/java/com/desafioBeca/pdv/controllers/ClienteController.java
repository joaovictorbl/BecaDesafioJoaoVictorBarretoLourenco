package com.desafioBeca.pdv.controllers;

import com.desafioBeca.pdv.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cliente")
@RestController

public class ClienteController {

    @PostMapping
    public ResponseEntity<Cliente> criar (@RequestBody Cliente cliente ) {
        System.out.println(cliente);

        cliente.setId(1);

        System.out.println("novo cliente");

        return ResponseEntity.created(null).body(cliente);

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar () {

        Cliente cli1 = new Cliente();
        cli1.setId(1);
        cli1.setNome("fulano");

        Cliente cli2 = new Cliente();
        cli2.setId(2);
        cli2.setNome("Alguém ");

        Cliente cli3 = new Cliente();
        cli3.setId(3);
        cli3.setNome("bla bla bla");

        return ResponseEntity.ok(List.of(
                cli1,
                cli2,
                cli3
        ));

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizar (@RequestBody Cliente cliente, @PathVariable Integer id) {

      cliente.setId(id);

      return ResponseEntity.ok(cliente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable Long id) {

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente>  obter (@PathVariable Integer id) {

        Cliente cli1 = new Cliente();
        cli1.setId(id);
        cli1.setNome("joão");

        return ResponseEntity.ok(cli1);
    }
}
