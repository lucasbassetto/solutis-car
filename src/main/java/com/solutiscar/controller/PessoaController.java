package com.solutiscar.controller;

import com.solutiscar.entities.Motorista;
import com.solutiscar.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cadastro")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

//    @PostMapping("/motorista")
//    public ResponseEntity<Motorista> insertDriver(@RequestBody Motorista obj) {
//        Motorista motorista = (Motorista) pessoaService.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(motorista.getId()).toUri();
//        return ResponseEntity.created(uri).body(motorista);
//    }
}
