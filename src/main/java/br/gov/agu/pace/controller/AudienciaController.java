package br.gov.agu.pace.controller;

import br.gov.agu.pace.dto.request.AudienciaRequestDTO;
import br.gov.agu.pace.dto.response.AudienciaResponseDTO;
import br.gov.agu.pace.service.AudienciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/audiencia")
@AllArgsConstructor
public class AudienciaController {

    private final AudienciaService audienciaService;

    @PostMapping
    public ResponseEntity<AudienciaResponseDTO> salvarAudiencia(@RequestBody AudienciaRequestDTO request){
        AudienciaResponseDTO response = audienciaService.salvarAudiencia(request);
        return ResponseEntity.created(URI.create("/audiencia" + response.getId())).body(response);
    }

    @GetMapping("{/id}")
    public ResponseEntity<AudienciaResponseDTO> buscarAudienciaPorId(@PathVariable Long id) {
        AudienciaResponseDTO response = audienciaService.buscarAudienciaPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AudienciaResponseDTO>> buscarTodasAudiencias(){
        List<AudienciaResponseDTO> response = audienciaService.listarTodasAudiencias();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAudiencia(@PathVariable Long id, @RequestBody AudienciaRequestDTO request){
        String response = audienciaService.atualizarAudiencia(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deletarAudiencia(@PathVariable Long id){
        audienciaService.deletarAudiencia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscarNumeroProcesso")
    public ResponseEntity<AudienciaResponseDTO> buscarPorNumeroProcesso(@RequestParam String numero_processo){
        AudienciaResponseDTO audiencia = audienciaService.buscarPorNumeroProcesso(numero_processo);
        return ResponseEntity.ok(audiencia);
    }

}
