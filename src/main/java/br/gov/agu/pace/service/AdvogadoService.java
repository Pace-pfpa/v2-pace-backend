package br.gov.agu.pace.service;

import br.gov.agu.pace.dto.request.AdvogadoRequestDTO;
import br.gov.agu.pace.dto.response.AdvogadoResponseDTO;
import br.gov.agu.pace.entity.AdvogadoEntity;
import br.gov.agu.pace.exceptions.ResourceNotFoundException;
import br.gov.agu.pace.mapper.AdvogadoMapper;
import br.gov.agu.pace.repositories.AdvogadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdvogadoService {

    private final AdvogadoMapper advogadoMapper;

    private final AdvogadoRepository advogadoRepository;

    public AdvogadoResponseDTO salvarAdvogado(AdvogadoRequestDTO request){
        if (advogadoRepository.existsByNumeroOab(request.getNumeroOab())){
            throw new ResourceNotFoundException("Advogado já cadastrado com o número OAB: " + request.getNumeroOab());
        }

        AdvogadoEntity entity = advogadoMapper.toEntity(request);
        return advogadoMapper.toResponseDTO(advogadoRepository.save(entity));
    }

    public AdvogadoResponseDTO buscarAdvogadoPorId(Long id) {
        AdvogadoEntity entity = advogadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Advogado não encontrado com id: " + id));
        return advogadoMapper.toResponseDTO(entity);
    }

    public List<AdvogadoResponseDTO> listarTodosAvogados(){
        List<AdvogadoEntity> listaAdvogados = advogadoRepository.findAll();
        return listaAdvogados.stream().map(advogadoMapper::toResponseDTO).toList();
    }

    public String atualizarAdvogado(Long id, AdvogadoRequestDTO request) {

        AdvogadoEntity advogadoQueSeraAtualizado = advogadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Advogado não encontrado com id: " + id));
        AdvogadoEntity advogadoAtualizado = AdvogadoEntity.builder()
                .id(advogadoQueSeraAtualizado.getId())
                .nome(request.getNome() != null ? request.getNome() : advogadoQueSeraAtualizado.getNome())
                .numeroOab(request.getNumeroOab() != null ? request.getNumeroOab() : advogadoQueSeraAtualizado.getNumeroOab())
                .build();

        advogadoRepository.save(advogadoAtualizado);
        return "Advogado atualizado com sucesso!";
    }

    public void deletarAdvogado(Long id) {
        advogadoRepository.deleteById(id);
    }

    public AdvogadoResponseDTO buscarPorNumeroOab(String numeroOab) {
        AdvogadoEntity entity = advogadoRepository.findByNumeroOab(numeroOab).orElseThrow(() -> new ResourceNotFoundException("Advogado não encontrado com numeroOab: " + numeroOab));
        return advogadoMapper.toResponseDTO(entity);
    }

    public List<AdvogadoResponseDTO> buscarPorNome(String nome) {
        List<AdvogadoEntity> listaAdvogados = advogadoRepository.findAdvogadoEntitiesByNomeIsNear(nome);
        return listaAdvogados.stream().map(advogadoMapper::toResponseDTO).toList();
    }
}
