package com.solutiscar.controller;

import com.solutiscar.model.dto.CarroDTO;
import com.solutiscar.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluguel")
public class AluguelController extends ControllerCrud<CarroDTO> {

    public AluguelController(@Autowired CarroService service) {
        super(service);
    }
}
