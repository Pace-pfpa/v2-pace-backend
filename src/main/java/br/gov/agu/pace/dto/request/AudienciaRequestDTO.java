package br.gov.agu.pace.dto.request;

import br.gov.agu.pace.enums.StatusAudiencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AudienciaRequestDTO {

    private String hora;

    private StatusAudiencia status;

    private String numeroProcesso;

    private String nomeParte;

    private String classe;

}
