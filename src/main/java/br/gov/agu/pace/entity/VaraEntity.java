package br.gov.agu.pace.entity;

import br.gov.agu.pace.enums.TipoVara;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table( name = "tb_vara" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoVara tipo;

    private String vara;


    private String uf;

    @OneToMany(mappedBy = "vara")
    private List<AudienciaEntity> audiencia;

}
