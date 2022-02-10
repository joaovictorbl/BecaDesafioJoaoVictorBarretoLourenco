package com.desafioBeca.pdv.controllers;

import com.desafioBeca.pdv.dtos.requests.PatchClienteResquest;
import com.desafioBeca.pdv.dtos.requests.PostClienteResquest;
import com.desafioBeca.pdv.dtos.responses.GetClienteListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetClienteObterResponse;
import com.desafioBeca.pdv.dtos.responses.PatchClienteResponse;
import com.desafioBeca.pdv.dtos.responses.PostClienteResponse;
import com.desafioBeca.pdv.models.Cliente;
import com.desafioBeca.pdv.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/cliente")
@RestController

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<PostClienteResponse> criar (@RequestBody @Valid PostClienteResquest postClienteResquest) {
        PostClienteResponse clienteCriado = clienteService.criar(postClienteResquest);
        return ResponseEntity.created(null).body(clienteCriado);

    }

    @GetMapping
    public ResponseEntity<List<GetClienteListarResponse>> listar () {
       List<GetClienteListarResponse> listaDeCliente = clienteService.listar();
        return ResponseEntity.ok(listaDeCliente);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchClienteResponse> atualizar (@RequestBody @Valid PatchClienteResquest cliente, @PathVariable Integer id) {
      PatchClienteResponse clienteAtualizado = clienteService.atualizar(cliente, id);
      return ResponseEntity.ok(clienteAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable Integer id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClienteObterResponse>  obter (@PathVariable Integer id) {
        GetClienteObterResponse obterCliente = clienteService.obter(id);
        return ResponseEntity.ok(obterCliente);
    }
}
