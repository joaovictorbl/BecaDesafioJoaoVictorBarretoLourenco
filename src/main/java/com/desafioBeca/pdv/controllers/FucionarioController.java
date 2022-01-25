package com.desafioBeca.pdv.controllers;


import com.desafioBeca.pdv.model.Fucionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/fucionario")
@RestController

public class FucionarioController {

    @PostMapping
    public ResponseEntity<Fucionario> criar (@RequestBody Fucionario fucionario) {
        System.out.println(fucionario);

        fucionario.setId(1);

        System.out.println("novo fucionario");

        return ResponseEntity.created(null).body(fucionario);

    }

     @GetMapping
    public ResponseEntity<List<Fucionario>> lista () {

        Fucionario fu1 = new Fucionario();
        fu1.setId(1);
        fu1.setNome("carlos");

         Fucionario fu2 = new Fucionario();
         fu2.setId(1);
         fu2.setNome("pedro");

        return ResponseEntity.ok(List.of(fu1, fu2 ));
     }

     @PatchMapping("/{id}")
     public ResponseEntity<Fucionario> atualizar (@RequestBody Fucionario fucionario, @PathVariable Integer id) {

        fucionario.setId(id);

        return ResponseEntity.ok(fucionario);

     }

     @DeleteMapping("/{id}")
     public ResponseEntity<String> deletar (@PathVariable Integer id) {

        return ResponseEntity.noContent().build();
     }

     @GetMapping("/{id}")
    public  ResponseEntity<Fucionario> obter (@PathVariable Integer id ) {

         Fucionario fu1 = new Fucionario();
         fu1.setId(id);
         fu1.setNome("patrão");

         return ResponseEntity.ok(fu1);
     }


}
