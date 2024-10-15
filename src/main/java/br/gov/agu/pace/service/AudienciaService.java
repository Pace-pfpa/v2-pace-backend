package br.gov.agu.pace.service;

import br.gov.agu.pace.dto.request.AudienciaRequestDTO;
import br.gov.agu.pace.dto.response.AudienciaResponseDTO;
import br.gov.agu.pace.entity.AudienciaEntity;
import br.gov.agu.pace.exceptions.ResourceNotFoundException;
import br.gov.agu.pace.mapper.AudienciaMapper;
import br.gov.agu.pace.repositories.AudienciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AudienciaService {

    private final AudienciaMapper audienciaMapper;

    private final AudienciaRepository audienciaRepository;

    public AudienciaResponseDTO salvarAudiencia (AudienciaRequestDTO request){
        if (audienciaRepository.existsByNumeroProcesso(request.getNumeroProcesso())){
            throw new ResourceNotFoundException("Audiência já cadastrada com o número OAB: " + request.getNumeroProcesso());
        }

        AudienciaEntity entity = audienciaMapper.toEntity(request);
        return audienciaMapper.toResponseDTO(audienciaRepository.save(entity));
    }

    public AudienciaResponseDTO buscarAudienciaPorId(Long id) {
        AudienciaEntity entity = audienciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(("Audiência não encontrada com id: " + id));
        return audienciaMapper.toResponseDTO(entity);
    }

    public List<AudienciaResponseDTO> listarTodasAudiencias(){
        List<AudienciaEntity> listaAudiencia = audienciaRepository.findAll();
        return listaAudiencia.stream().map(audienciaMapper::toResponseDTO).toList();
    }

    public String atualizarAudiencia (Long id, AudienciaRequestDTO request) {
        AudienciaEntity audienciaQueSeraAtualizada = audienciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Audiência não encontrada com id: " + id));

        AudienciaEntity audienciaAtualizada = AudienciaEntity.builder()
                .id(audienciaQueSeraAtualizada.getId())
                .data(request.getData() != null ? request.getData() : audienciaQueSeraAtualizada.getData())
                .hora(request.getHora() != null ? request.getHora() : audienciaQueSeraAtualizada.getHora())
                .turno(request.getTurno() != null ? request.getTurno() : audienciaQueSeraAtualizada.getTurno())
                .sala(request.getSala() != null ? request.getSala() : audienciaQueSeraAtualizada.getHora())
                .numeroProcesso(request.getNumeroProcesso() != null ? request.getNumeroProcesso() : audienciaQueSeraAtualizada.getNumeroProcesso())
                .nomeParte(request.getNomeParte() != null ? request.getNomeParte() : audienciaQueSeraAtualizada.getNomeParte())
                .classe(request.getClasse() != null ? request.getClasse() : audienciaQueSeraAtualizada.getClasse())
                .status(request.getStatus() != null ? request.getStatus() : audienciaQueSeraAtualizada.getStatus())
                .tipo(request.getTipo() != null ? request.getTipo() : audienciaQueSeraAtualizada.getTipo())
                .build();

        audienciaRepository.save(audienciaAtualizada);
        return "Audiênci atualizada com sucesso!";
    }

    public void deletarAudiencia(Long id) {
        audienciaRepository.deleteById(id);
    }

    public
}
