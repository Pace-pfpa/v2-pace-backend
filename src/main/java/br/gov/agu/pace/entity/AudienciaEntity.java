package br.gov.agu.pace.entity;

import br.gov.agu.pace.enums.TipoTurno;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    private Long id;

    private String numeroProcesso;

    private LocalDate data;

    private String hora;

    private TipoTurno turno;

    private String sala;

    private String nomeParte;

}
