package com.solutiscar.controller;

import com.solutiscar.exception.ResourceNotFoundException;
import com.solutiscar.model.dto.aluguel.ApoliceSeguroDTO;
import com.solutiscar.services.carro.CarroService;
import com.solutiscar.services.ServiceCrud;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class ControllerCrud<T> {

    private ServiceCrud service;

    public ControllerCrud(ServiceCrud service) {
        this.service = service;
    }

    @Operation(summary = "Listar por id", description = "Retorna as informações por id")
    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable Long id) {
        return ResponseEntity.ok((T) service.findById(id));
    }

    @Operation(summary = "Listar todos", description = "Retorna as informações de todos")
    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok((List<T>) service.findAll());
    }

    @Operation(summary = "Adicionar", description = "Adiciona as informações")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<T> insert(@RequestBody T obj) {
        return ResponseEntity.ok((T) service.insert(obj));
    }

    @Operation(summary = "Editar", description = "Edita as informações. Retorna o codigo 204 (No Content)")
    @PutMapping
    public ResponseEntity<T> update(@RequestBody T obj) {
        return ResponseEntity.ok((T) service.insert(obj));
    }

    @Operation(summary = "Deletar por id", description = "Apaga as informações. Retorna o codigo 204 (No Content)")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
