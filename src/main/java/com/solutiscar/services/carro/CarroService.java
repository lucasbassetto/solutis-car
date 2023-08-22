package com.solutiscar.services.carro;

import com.solutiscar.exception.DatabaseException;
import com.solutiscar.exception.ResourceNotFoundException;
import com.solutiscar.mapper.carro.CarroMapper;
import com.solutiscar.model.dto.carro.CarroDTO;
import com.solutiscar.model.entities.carro.Acessorio;
import com.solutiscar.model.entities.carro.Carro;
import com.solutiscar.model.entities.carro.ModeloCarro;
import com.solutiscar.repositories.carro.AcessorioRepository;
import com.solutiscar.repositories.carro.CarroRepository;
import com.solutiscar.repositories.carro.ModeloCarroRepository;
import com.solutiscar.services.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class CarroService extends ServiceCrud<CarroDTO> {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private CarroMapper carroMapper;

    @Override
    public CarroDTO findById(Long id) {
        return this.carroMapper.modelToDTO(this.carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<CarroDTO> findAll() {
        List<Carro> list = this.carroRepository.findAll();
        return list.stream().map(this.carroMapper::modelToDTO).toList();
    }

    @Override
    public CarroDTO insert(CarroDTO dto) {
        Carro carroInsert = carroRepository.save(this.carroMapper.dtoToModel(dto));
        return this.carroMapper.modelToDTO(carroInsert);
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.carroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public CarroDTO update(CarroDTO dto) {
        Carro carroExistente = carroRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado: " + dto.getId()));

        carroExistente.setPlaca(dto.getPlaca());
        carroExistente.setChassi(dto.getChassi());
        carroExistente.setCor(dto.getCor());
        carroExistente.setValorDiaria(dto.getValorDiaria());
        carroExistente.setImageUrl(dto.getImageUrl());

        List<Acessorio> novosAcessorios = acessorioRepository.findAllById(dto.getAcessorioId());
        carroExistente.setAcessorios(novosAcessorios);

        ModeloCarro modeloCarro = modeloCarroRepository.findById(dto.getModeloCarroId())
                .orElseThrow(() -> new RuntimeException("Modelo de carro não encontrado: " + dto.getModeloCarroId()));
        carroExistente.setModeloCarro(modeloCarro);

        Carro carroAtualizado = carroRepository.save(carroExistente);

        return carroMapper.modelToDTO(carroAtualizado);
    }

    public List<CarroDTO> findAvailableCarsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Carro> availableCars = carroRepository.findAvailableCarsByDateRange(startDate, endDate);
        return availableCars.stream()
                .map(carroMapper::modelToDTO)
                .collect(Collectors.toList());
    }
}
