package br.gov.agu.pace.service;

import br.gov.agu.pace.DTO.AdvogadoRequestDTO;
import br.gov.agu.pace.DTO.AdvogadoResponseDTO;
import br.gov.agu.pace.entities.AdvogadoEntity;
import br.gov.agu.pace.repositories.AdvogadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class AdvogadoService {

    private final AdvogadoRepository advogadoRepository;

    public AdvogadoResponseDTO cadastrarAdvogado(AdvogadoRequestDTO requestDTO){
        AdvogadoEntity advogado = new AdvogadoEntity();
        advogado.setNome(requestDTO.getNome());
        advogado.setNumeroOAB(requestDTO.getNumeroOAB());
        AdvogadoEntity advogadoSalvo = advogadoRepository.save(advogado);
        return new AdvogadoResponseDTO(advogadoSalvo.getId(), advogadoSalvo.getNome(), advogadoSalvo.getNumeroOAB());
    }

    public AdvogadoResponseDTO buscarAdvogadoPorId(Long id){
        AdvogadoEntity advogadoBuscadoPorId = advogadoRepository.findById(id).get();
        return new AdvogadoResponseDTO(advogadoBuscadoPorId.getId(), advogadoBuscadoPorId.getNome(), advogadoBuscadoPorId.getPreco());
    }

    public List<AdvogadoEntity> buscarTodosAdvogados(){
        return advogadoRepository.findAll();
    }

    public AdvogadoEntity atualizarAdvogado(Long id, AdvogadoRequestDTO advogadoRequestDTO){
        AdvogadoEntity advogadoAtualizar = advogadoRepository.findById(id).get();
        advogadoAtualizar.setNome(advogadoRequestDTO.getNome());
        advogadoAtualizar.setNumeroOAB(advogadoRequestDTO.getNumeroOAB());
        AdvogadoEntity advogadoAtualizado = advogadoRepository.save(advogadoAtualizar);
        return advogadoAtualizado;
    }

    public void deletarAdvogadoPorId (Long id){
        advogadoRepository.deleteById(id);
    }

    public AdvogadoResponseDTO buscarAdvogadoPorNumeroOAB(String numeroOAB){
        AdvogadoEntity advogadoBuscadoPorNumeroOAB = advogadoRepository.findByNumeroOAB(numeroOAB).get();
        return new AdvogadoResponseDTO(advogadoBuscadoPorNumeroOAB.getId(), advogadoBuscadoPorNumeroOAB.getNome(), advogadoBuscadoPorNumeroOAB.getNumeroOAB())
    }

}
