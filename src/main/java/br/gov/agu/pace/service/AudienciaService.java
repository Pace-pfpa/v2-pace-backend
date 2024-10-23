package br.gov.agu.pace.service;

import br.gov.agu.pace.dto.request.AudienciaRequestDTO;
import br.gov.agu.pace.dto.response.AudienciaResponseDTO;
import br.gov.agu.pace.entity.AudienciaEntity;
import br.gov.agu.pace.exceptions.ResourceAlreadyExistException;
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

    public AudienciaResponseDTO salvarAudiencia(AudienciaRequestDTO request){
        if (audienciaRepository.existsByNumeroProcesso(request.getNumeroProcesso())){
            throw new ResourceAlreadyExistException("Audiencia já cadastrada com o numero do processo: " + request.getNumeroProcesso());
        }

        AudienciaEntity entity = audienciaMapper.toEntity(request);
        return audienciaMapper.toResponseDTO(audienciaRepository.save(entity));
    }

    public AudienciaResponseDTO buscarAudienciaPorId(Long id){
        AudienciaEntity entity = audienciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Audeincia não encontrada com id: " + id));
        return audienciaMapper.toResponseDTO(entity);
    }

    public List<AudienciaResponseDTO> listarTodasAudiencias(){
        List<AudienciaEntity> listaAudiencias = audienciaRepository.findAll();
        return listaAudiencias.stream().map(audienciaMapper::toResponseDTO).toList();
    }

    public String atualizarAudiencia(Long id, AudienciaRequestDTO request){
        AudienciaEntity audienciaQueSeraAtualizada = audienciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Audiencia não encontrada com id: " + id));
        AudienciaEntity audienciaAtualizada = AudienciaEntity.builder()
                .id(audienciaQueSeraAtualizada.getId())
                .hora(request.getHora() != null ? request.getHora() : audienciaQueSeraAtualizada.getHora())
                .status(request.getStatus() != null ? request.getStatus() : audienciaQueSeraAtualizada.getStatus())
                .numeroProcesso(request.getNumeroProcesso() != null ? request.getNumeroProcesso() : audienciaQueSeraAtualizada.getNumeroProcesso())
                .nomeParte(request.getNomeParte() != null ? request.getNomeParte() : audienciaQueSeraAtualizada.getNumeroProcesso())
                .classe(request.getClasse() != null ? request.getClasse() : audienciaQueSeraAtualizada.getClasse())
                .build();

        audienciaRepository.save(audienciaAtualizada);
        return "Audiencia atualizada com sucesso!";
    }

    public void deletarAudiencia(Long id) {
        audienciaRepository.deleteById(id);
    }

    public AudienciaResponseDTO buscarPorNumeroProcesso(String numero_processo){
        AudienciaEntity entity = audienciaRepository.findByNumeroProcesso(numero_processo).orElseThrow(() -> new ResourceNotFoundException("Audiencia não encontrada com numero do Processo: "+numero_processo));
        return audienciaMapper.toResponseDTO(entity);
    }

}
