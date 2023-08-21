package com.solutiscar.mapper.carro;

import com.solutiscar.model.dto.carro.ModeloCarroDTO;
import com.solutiscar.model.entities.carro.Fabricante;
import com.solutiscar.model.entities.carro.ModeloCarro;
import com.solutiscar.repositories.carro.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModeloCarroIml implements ModeloCarroMapper {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public ModeloCarroDTO modelToDTO(ModeloCarro entity) {
        if ( entity == null ) {
            return null;
        }

        ModeloCarroDTO modeloCarroDTO = new ModeloCarroDTO();

        modeloCarroDTO.setId(entity.getId());
        modeloCarroDTO.setDescricao(entity.getDescricao());
        modeloCarroDTO.setCategoria(entity.getCategoria());
        modeloCarroDTO.setFabricanteId(entity.getFabricante().getId());

        return modeloCarroDTO;
    }

    @Override
    public ModeloCarro dtoToModel(ModeloCarroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ModeloCarro modeloCarroEntity = new ModeloCarro();

        modeloCarroEntity.setId(dto.getId());
        modeloCarroEntity.setDescricao(dto.getDescricao());
        modeloCarroEntity.setCategoria(dto.getCategoria());

        if (dto.getFabricanteId() != null) {
            Fabricante fabricante = fabricanteRepository.findById(dto.getFabricanteId()).orElse(null);
            modeloCarroEntity.setFabricante(fabricante);
        }

        return modeloCarroEntity;
    }
}
