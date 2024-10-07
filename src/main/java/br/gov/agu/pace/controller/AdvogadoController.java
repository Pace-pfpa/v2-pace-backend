package br.gov.agu.pace.controller;

import br.gov.agu.pace.dto.request.AdvogadoRequestDTO;
import br.gov.agu.pace.dto.response.AdvogadoResponseDTO;
import br.gov.agu.pace.service.AdvogadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/advogado")
@AllArgsConstructor
public class AdvogadoController {

    private final AdvogadoService advogadoService;

    @PostMapping
    public ResponseEntity<AdvogadoResponseDTO> salvarAdvogado(@RequestBody AdvogadoRequestDTO request){
        AdvogadoResponseDTO response = advogadoService.salvarAdvogado(request);
        return ResponseEntity.ok(response);
    }



}
