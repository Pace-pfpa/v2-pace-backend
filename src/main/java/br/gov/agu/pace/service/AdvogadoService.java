package br.gov.agu.pace.service;

import br.gov.agu.pace.dto.request.AdvogadoRequestDTO;
import br.gov.agu.pace.dto.response.AdvogadoResponseDTO;
import br.gov.agu.pace.entity.AdvogadoEntity;
import br.gov.agu.pace.mapper.AdvogadoMapper;
import br.gov.agu.pace.repositories.AdvogadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdvogadoService {

    private final AdvogadoMapper advogadoMapper;

    private final AdvogadoRepository advogadoRepository;

    public AdvogadoResponseDTO salvarAdvogado(AdvogadoRequestDTO request){
        AdvogadoEntity entity = advogadoMapper.toEntity(request);
        return advogadoMapper.toResponseDTO(advogadoRepository.save(entity));
    }
}
