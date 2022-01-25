package com.desafioBeca.pdv.controllers;


import com.desafioBeca.pdv.model.Venda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/venda")
@RestController

public class VendaController {

    @PostMapping
    public ResponseEntity<Venda> criar(@RequestBody Venda venda ) {
        System.out.println(venda);

        venda.setId(1);

        System.out.println("Nova venda ");

        return ResponseEntity.created(null).body(venda);

    }

    @GetMapping
    public ResponseEntity<List<Venda>> lista() {

        Venda ven1 = new Venda();
        ven1.setId(1);
        ven1.setNome("venda concluida");

        Venda ven2 = new Venda();
        ven2.setId(2);
        ven2.setNome("venda efetuada");

        Venda ven3 = new Venda();
        ven3.setId(3);
        ven3.setNome("ficando rico");

        return ResponseEntity.ok(List.of(
                ven1,
                ven2,
                ven3
        ));

    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Venda> atualizar(@RequestBody Venda venda, @PathVariable Integer id) {

        venda.setId(id);

        return ResponseEntity.ok(venda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable Integer id) {

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> obter(@PathVariable Integer id ) {

        Venda ven1 = new Venda();
        ven1.setId(id);
        ven1.setNome("ta de boa ");

        return ResponseEntity.ok(ven1);

    }
}
