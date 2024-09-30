package br.gov.agu.pace.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdvogadoRequestDTO {
    private Long id;
    private String nome;
    private String numeroOAB;
}
