package com.solutiscar.controller;

import com.solutiscar.model.dto.MotoristaDTO;
import com.solutiscar.services.MotoristaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/motorista")
public class MotoristaController extends ControllerCrud<MotoristaDTO> {

    public MotoristaController(@Autowired MotoristaService service) {
        super(service);
    }
}
