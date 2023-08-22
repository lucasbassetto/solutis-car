package com.solutiscar.controller.carro;

import com.solutiscar.controller.ControllerCrud;
import com.solutiscar.model.dto.carro.CarroDTO;
import com.solutiscar.services.carro.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/carros")
public class CarroController extends ControllerCrud<CarroDTO> {

    private final CarroService carroService;

    public CarroController(@Autowired CarroService service) {
        super(service);
        this.carroService = service;
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<CarroDTO>> getAvailableCarsByDateRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        List<CarroDTO> carrosDisponiveis = carroService.findAvailableCarsByDateRange(startDate, endDate);
        return new ResponseEntity<>(carrosDisponiveis, HttpStatus.OK);
    }
}
