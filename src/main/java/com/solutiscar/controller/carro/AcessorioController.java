package com.solutiscar.controller.carro;

import com.solutiscar.controller.ControllerCrud;
import com.solutiscar.model.dto.carro.AcessorioDTO;
import com.solutiscar.services.carro.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acessorios")
@CrossOrigin
public class AcessorioController extends ControllerCrud<AcessorioDTO> {

    public AcessorioController(@Autowired AcessorioService service) {
        super(service);
    }
}
