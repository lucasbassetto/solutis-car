package com.solutiscar.controller;

import com.solutiscar.model.dto.AcessorioDTO;
import com.solutiscar.model.dto.CarroDTO;
import com.solutiscar.model.entities.Acessorio;
import com.solutiscar.services.AcessorioService;
import com.solutiscar.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acessorio")
public class AcessorioController extends ControllerCrud<AcessorioDTO> {

    public AcessorioController(@Autowired AcessorioService service) {
        super(service);
    }
}
