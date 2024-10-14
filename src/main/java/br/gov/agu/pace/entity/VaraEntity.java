package br.gov.agu.pace.entity;

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

    private String vara;

    private String uf;

    @OneToMany(mappedBy = "vara")
    private List<AudienciaEntity> audiencia;
}
