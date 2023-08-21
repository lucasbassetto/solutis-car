package com.solutiscar.controller.carro;

import com.solutiscar.controller.ControllerCrud;
import com.solutiscar.model.dto.carro.FabricanteDTO;
import com.solutiscar.services.carro.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fabricantes")
public class FabricanteController extends ControllerCrud<FabricanteDTO> {

    public FabricanteController(@Autowired FabricanteService service) {
        super(service);
    }
}
