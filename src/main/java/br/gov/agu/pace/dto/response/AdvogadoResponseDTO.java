package br.gov.agu.pace.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvogadoResponseDTO {

    private Long id;

    private String nome;

    private String numeroOab;

}
