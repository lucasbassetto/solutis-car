package com.solutiscar.controller;

import com.solutiscar.model.dto.CarroDTO;
import com.solutiscar.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apolice")
public class ApoliceSeguroController extends ControllerCrud<CarroDTO> {

    public ApoliceSeguroController(@Autowired CarroService service) {
        super(service);
    }
}
