package br.gov.agu.pace.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name ="tb_advogado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvogadoEntity {

    @Id // indica que o atributo é uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define como será gerado o id
    private Long id;

    @Column(nullable = false, name = "nome" )
    private String nome;

    @Column(unique = true)
    private String numeroOAB;
}