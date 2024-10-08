package br.gov.agu.pace.controller;

import br.gov.agu.pace.dto.request.AdvogadoRequestDTO;
import br.gov.agu.pace.dto.response.AdvogadoResponseDTO;
import br.gov.agu.pace.service.AdvogadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/advogado")
@AllArgsConstructor
public class AdvogadoController {

    private final AdvogadoService advogadoService;

    @PostMapping
    public ResponseEntity<AdvogadoResponseDTO> salvarAdvogado(@RequestBody AdvogadoRequestDTO request){
        AdvogadoResponseDTO response = advogadoService.salvarAdvogado(request);
        return ResponseEntity.created(URI.create("/advogado/" + response.getId())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvogadoResponseDTO> buscarAdvogadoPorId(@PathVariable Long id){
        AdvogadoResponseDTO response = advogadoService.buscarAdvogadoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AdvogadoResponseDTO>> buscarTodosAdvogados(){
        List<AdvogadoResponseDTO> response = advogadoService.listarTodosAvogados();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAdvogado(@PathVariable Long id, @RequestBody AdvogadoRequestDTO request){
        String response = advogadoService.atualizarAdvogado(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdvogado(@PathVariable Long id){
        advogadoService.deletarAdvogado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscarNumeroOab")
    public ResponseEntity<AdvogadoResponseDTO> buscarPorNumeroOab(@RequestParam String numeroOab){
        AdvogadoResponseDTO advogado = advogadoService.buscarPorNumeroOab(numeroOab);
        return ResponseEntity.ok(advogado);
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<AdvogadoResponseDTO>> buscarPorNome(@RequestParam String nome){
        List<AdvogadoResponseDTO> advogados = advogadoService.buscarPorNome(nome);
        return ResponseEntity.ok(advogados);
    }



}
