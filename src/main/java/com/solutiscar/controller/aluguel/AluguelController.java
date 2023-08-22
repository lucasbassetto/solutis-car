package com.solutiscar.controller.aluguel;

import com.solutiscar.controller.ControllerCrud;
import com.solutiscar.model.dto.aluguel.AluguelDTO;
import com.solutiscar.model.dto.aluguel.ApoliceSeguroDTO;
import com.solutiscar.services.aluguel.AluguelService;
import com.solutiscar.services.aluguel.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alugueis")
public class AluguelController extends ControllerCrud<AluguelDTO> {

    public AluguelController(@Autowired AluguelService service) {
        super(service);
    }
}
