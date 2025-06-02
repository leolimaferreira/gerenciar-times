package com.gerenciartimes.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "jogador")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nascimento;

    private String posicao;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;
}
