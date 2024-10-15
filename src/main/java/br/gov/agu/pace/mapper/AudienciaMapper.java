package br.gov.agu.pace.mapper;

import br.gov.agu.pace.dto.request.AdvogadoRequestDTO;
import br.gov.agu.pace.dto.response.AudienciaResponseDTO;
import br.gov.agu.pace.entity.AudienciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AudienciaMapper {
    @Mapping(target = "id", ignore = true)
    AudienciaEntity toEntity(AdvogadoRequestDTO request);

    AudienciaResponseDTO toResponseDTO(AudienciaEntity entity);
}
