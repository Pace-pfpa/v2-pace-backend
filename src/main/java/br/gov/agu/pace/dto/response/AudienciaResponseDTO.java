package br.gov.agu.pace.dto.response;

import br.gov.agu.pace.enums.StatusAudiencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AudienciaResponseDTO {

    private Long id;

    private String hora;

    private StatusAudiencia status;

    private String numero_processo;

    private String nome_parte;

    private String classe;

}
