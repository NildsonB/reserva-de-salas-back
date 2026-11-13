package com.reserva_de_salas.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    Sala sala;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    Usuario usuario;
    @NotBlank
    LocalDateTime inicio;
    @NotBlank
    LocalDateTime fim;
    StatusReserva status;

    public Reserva(Sala sala, Usuario usuario, LocalDateTime inicio, LocalDateTime fim) {
        this.sala = sala;
        this.usuario = usuario;
        this.inicio = inicio;
        if(fim.isAfter(inicio)) {
            this.fim = fim;
        }else{
            throw new IllegalArgumentException("Data final deve ser posterior a data inicial");
        }
        this.status = StatusReserva.ATIVA;
    }

    public Reserva() {
    }

    public UUID getId() {
        return id;
    }

    public Sala getSala() {
        return sala;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public StatusReserva getStatus() {
        return status;
    }
}
