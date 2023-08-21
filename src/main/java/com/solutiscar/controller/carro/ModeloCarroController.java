package com.solutiscar.controller.carro;

import com.solutiscar.controller.ControllerCrud;
import com.solutiscar.model.dto.carro.ModeloCarroDTO;
import com.solutiscar.services.carro.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelos")
public class ModeloCarroController extends ControllerCrud<ModeloCarroDTO> {

    public ModeloCarroController(@Autowired ModeloCarroService service) {
        super(service);
    }
}
