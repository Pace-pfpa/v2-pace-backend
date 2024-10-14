package br.gov.agu.pace.dto.request;

import br.gov.agu.pace.enums.StatusAudiencia;
import br.gov.agu.pace.enums.TipoAudiencia;
import br.gov.agu.pace.enums.TipoTurno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AudienciaRequestDTO {

    private LocalDate data;

    private String hora;

    private TipoTurno turno;

    private String sala;

    private String numeroProcesso;

    private String nomeParte;

    private String classe;

    private StatusAudiencia status;

    private TipoAudiencia tipo;


}
