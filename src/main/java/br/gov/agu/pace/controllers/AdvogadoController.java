package br.gov.agu.pace.controllers;

import br.gov.agu.pace.DTO.AdvogadoRequestDTO;
import br.gov.agu.pace.DTO.AdvogadoResponseDTO;
import br.gov.agu.pace.entities.AdvogadoEntity;
import br.gov.agu.pace.service.AdvogadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advogado")
@AllArgsConstructor
public class AdvogadoController {

    private final AdvogadoService advogadoService;

    @PostMapping
    public ResponseEntity <AdvogadoResponseDTO> createAdvogado(@RequestBody AdvogadoRequestDTO advogadoRequestDTO){
        AdvogadoResponseDTO response = advogadoService.cadastrarAdvogado(advogadoRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvogadoResponseDTO> buscarAdvogadoPorId(@PathVariable Long id){
        AdvogadoResponseDTO response = advogadoService.buscarAdvogadoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AdvogadoEntity>> buscarTodosAdvogados(){
        List<AdvogadoEntity> listaDeAdvogadosPorId = advogadoService.buscarTodosAdvogados();
        return ResponseEntity.ok(listaDeAdvogadosPorId);
    }

    @PutMapping
    public ResponseEntity<AdvogadoEntity> atualizarAdvogado(@PathVariable Long id, @RequestBody AdvogadoRequestDTO advogadoRequestDTO){
        AdvogadoEntity advogadoAtualizado = advogadoService.atualizarAdvogado(id, advogadoRequestDTO);
        return ResponseEntity.ok(advogadoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdvogadoPorId(@PathVariable Long id){
        advogadoService.deletarAdvogadoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{numeroOAB}")
    public ResponseEntity<AdvogadoResponseDTO> buscarAdvogadoPorNumeroOAB(@PathVariable String numeroOAB){
        AdvogadoResponseDTO response = advogadoService.buscarAdvogadoPorNumeroOAB(numeroOAB);
        return ResponseEntity.ok(response);
    }
}
