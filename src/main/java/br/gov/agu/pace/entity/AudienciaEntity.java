package br.gov.agu.pace.entity;

import br.gov.agu.pace.enums.StatusAudiencia;
import br.gov.agu.pace.enums.TipoAudiencia;
import br.gov.agu.pace.enums.TipoTurno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_audiencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AudienciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private String hora;

    private TipoTurno turno;

    private String sala;

    private String numeroProcesso;

    private String nomeParte;

    @ManyToOne
    @JoinColumn(name = "vara_id", nullable = false)
    private VaraEntity vara;

    private String classe;

    private StatusAudiencia status;

    private TipoAudiencia tipo;
}
