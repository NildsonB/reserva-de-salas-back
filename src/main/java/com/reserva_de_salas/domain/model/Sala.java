package com.reserva_de_salas.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String nome;
    @Min(value=1, message="A capacidade deve ser maior que 0")
    private Integer capacidade;
    private boolean ativa;

    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.ativa = true;
    }

    public Sala() {
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public boolean isAtiva() {
        return ativa;
    }
}
