package br.gov.agu.pace.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_advogado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvogadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String numeroOab;

}
