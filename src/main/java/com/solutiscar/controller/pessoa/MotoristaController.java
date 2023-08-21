package com.solutiscar.controller.pessoa;

import com.solutiscar.controller.ControllerCrud;
import com.solutiscar.model.dto.pessoa.MotoristaDTO;
import com.solutiscar.services.pessoa.MotoristaService;

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
