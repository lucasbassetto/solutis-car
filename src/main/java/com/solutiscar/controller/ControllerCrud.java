package com.solutiscar.controller;

import com.solutiscar.services.carro.CarroService;
import com.solutiscar.services.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class ControllerCrud<T> {

    private ServiceCrud service;

    public ControllerCrud(ServiceCrud service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable Long id) {
        return ResponseEntity.ok((T) service.findById(id));
    }

    @GetMapping
    public  ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok( (List<T>) service.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<T> insert(@RequestBody T obj) {
        return ResponseEntity.ok((T) service.insert(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
