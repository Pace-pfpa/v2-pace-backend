package br.gov.agu.pace.entity;

import br.gov.agu.pace.enums.StatusAudiencia;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_audiencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AudienciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hora;

    private StatusAudiencia status;

    //id_pauta

    private String numeroProcesso;

    private String nomeParte;

    //Transferir para tabela pauta
//    @ManyToOne
//    @JoinColumn(name = "vara_id", nullable = false)
//    private VaraEntity vara;

    private String classe;

}
