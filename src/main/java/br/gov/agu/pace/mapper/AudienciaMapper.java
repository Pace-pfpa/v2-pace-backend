package br.gov.agu.pace.mapper;

import br.gov.agu.pace.dto.request.AudienciaRequestDTO;
import br.gov.agu.pace.dto.response.AudienciaResponseDTO;
import br.gov.agu.pace.entity.AudienciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AudienciaMapper {
    @Mapping(target = "id", ignore = true)
    AudienciaEntity toEntity(AudienciaRequestDTO request);

    AudienciaResponseDTO toResponseDTO(AudienciaEntity entity);
}
