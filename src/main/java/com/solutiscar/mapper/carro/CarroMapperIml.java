package com.solutiscar.mapper.carro;

import com.solutiscar.model.dto.carro.CarroDTO;
import com.solutiscar.model.entities.carro.Acessorio;
import com.solutiscar.model.entities.carro.Carro;
import com.solutiscar.model.entities.carro.ModeloCarro;
import com.solutiscar.repositories.carro.AcessorioRepository;
import com.solutiscar.repositories.carro.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarroMapperIml implements CarroMapper {


    @Autowired
    private final ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private final AcessorioRepository acessorioRepository;

    public CarroMapperIml(ModeloCarroRepository modeloCarroRepository, AcessorioRepository acessorioRepository) {
        this.modeloCarroRepository = modeloCarroRepository;
        this.acessorioRepository = acessorioRepository;
    }
    @Override
    public CarroDTO modelToDTO(Carro entity) {
        if ( entity == null ) {
            return null;
        }

        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setId(entity.getId());
        carroDTO.setPlaca(entity.getPlaca());
        carroDTO.setChassi(entity.getChassi());
        carroDTO.setCor(entity.getCor());
        carroDTO.setValorDiaria(entity.getValorDiaria());
        carroDTO.setImageUrl(entity.getImageUrl());
        carroDTO.setModeloCarroId(entity.getModeloCarro().getId());

        List<Long> acessorioIds = entity.getAcessorios().stream()
                .map(Acessorio::getId)
                .collect(Collectors.toList());
        carroDTO.setAcessorioId(acessorioIds);

        return carroDTO;
    }

    @Override
    public Carro dtoToModel(CarroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Carro carroEntity = new Carro();

        carroEntity.setId(dto.getId());
        carroEntity.setPlaca(dto.getPlaca());
        carroEntity.setChassi(dto.getChassi());
        carroEntity.setCor(dto.getCor());
        carroEntity.setValorDiaria(dto.getValorDiaria());
        carroEntity.setImageUrl(dto.getImageUrl());


        if (dto.getModeloCarroId() != null) {
            ModeloCarro modeloCarro = modeloCarroRepository.findById(dto.getModeloCarroId()).orElse(null);
            carroEntity.setModeloCarro(modeloCarro);
        }

        if (dto.getAcessorioId() != null) {
            List<Acessorio> acessorios = acessorioRepository.findAllById(dto.getAcessorioId());
            carroEntity.setAcessorios(new ArrayList<>(acessorios));
        }

        return carroEntity;
    }
}
