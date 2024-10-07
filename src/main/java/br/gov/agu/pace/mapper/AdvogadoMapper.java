package br.gov.agu.pace.mapper;

import br.gov.agu.pace.dto.request.AdvogadoRequestDTO;
import br.gov.agu.pace.dto.response.AdvogadoResponseDTO;
import br.gov.agu.pace.entity.AdvogadoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AdvogadoMapper {

    @Mapping(target = "id", ignore = true)
    AdvogadoEntity toEntity(AdvogadoRequestDTO request);

    AdvogadoResponseDTO toResponseDTO(AdvogadoEntity entity);
}
