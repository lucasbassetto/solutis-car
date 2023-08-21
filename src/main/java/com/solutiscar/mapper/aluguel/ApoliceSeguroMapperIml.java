package com.solutiscar.mapper.aluguel;

import com.solutiscar.model.dto.aluguel.ApoliceSeguroDTO;
import com.solutiscar.model.entities.aluguel.ApoliceSeguro;
import org.springframework.stereotype.Component;

@Component
public class ApoliceSeguroMapperIml implements ApoliceSeguroMapper {

    @Override
    public ApoliceSeguroDTO modelToDTO(ApoliceSeguro entity) {
        if ( entity == null ) {
            return null;
        }

        ApoliceSeguroDTO apoliceSeguroDTO = new ApoliceSeguroDTO();

        apoliceSeguroDTO.setId(entity.getId());
        apoliceSeguroDTO.setValorFranquia(entity.getValorFranquia());
        apoliceSeguroDTO.setProtecaoTerceiro(entity.isProtecaoTerceiro());
        apoliceSeguroDTO.setProtecaoCausasNaturais(entity.isProtecaoCausasNaturais());
        apoliceSeguroDTO.setProtecaoRoubo(entity.isProtecaoRoubo());

        return apoliceSeguroDTO;
    }

    @Override
    public ApoliceSeguro dtoToModel(ApoliceSeguroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ApoliceSeguro apoliceSeguroEntity = new ApoliceSeguro();

        apoliceSeguroEntity.setId(dto.getId());
        apoliceSeguroEntity.setValorFranquia(dto.getValorFranquia());
        apoliceSeguroEntity.setProtecaoTerceiro(dto.isProtecaoTerceiro());
        apoliceSeguroEntity.setProtecaoCausasNaturais(dto.isProtecaoCausasNaturais());
        apoliceSeguroEntity.setProtecaoRoubo(dto.isProtecaoRoubo());

        return apoliceSeguroEntity;
    }
}
