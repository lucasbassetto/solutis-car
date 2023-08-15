package com.solutiscar.controller;

import com.solutiscar.services.ServiceCrud;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class ControllerCrud<T> {

    private ServiceCrud service;

    public ControllerCrud(ServiceCrud service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<T> insert(@RequestBody T payload) {
        return ResponseEntity.ok((T) service.insert(payload));
    }
}
