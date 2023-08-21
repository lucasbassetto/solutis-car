package com.solutiscar.controller.carro;

import com.solutiscar.controller.ControllerCrud;
import com.solutiscar.model.dto.carro.CarroDTO;
import com.solutiscar.services.carro.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carros")
public class CarroController extends ControllerCrud<CarroDTO> {

    public CarroController(@Autowired CarroService service) {
        super(service);
    }
}
