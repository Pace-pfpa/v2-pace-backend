package br.gov.agu.pace.controllers;

import br.gov.agu.pace.DTO.AdvogadoDTO;
import br.gov.agu.pace.repositories.AdvogadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advogado")
@AllArgsConstructor
public class AdvogadoController {
    @Autowired
    private AdvogadoRepository repository;
    @GetMapping
    public ResponseEntity getAllAdvogados(){
        var allAdvogados = repository.findAll();
        return ResponseEntity.ok(allAdvogados);
    }

    //@PostMapping
    //public ResponseEntity createAdvogado(@RequestBody AdvogadoDTO data){
    //}
}
