package com.solutiscar.controller;

import com.solutiscar.model.dto.CarroDTO;
import com.solutiscar.model.dto.MotoristaDTO;
import com.solutiscar.services.CarroService;
import com.solutiscar.services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carro")
public class CarroController extends ControllerCrud<CarroDTO> {

    public CarroController(@Autowired CarroService service) {
        super(service);
    }
}
