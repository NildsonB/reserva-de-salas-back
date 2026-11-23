package com.reserva_de_salas.domain.model;

import com.reserva_de_salas.domain.dto.CriarUsuarioDto;
import com.reserva_de_salas.domain.dto.UsuarioDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String nome;
    String email;

    public Usuario(CriarUsuarioDto dto) {
        this.nome = dto.nome();
        this.email = dto.email();
    }

    public Usuario() {

    }

    public void atualizar(UsuarioDto dto) {
        this.nome = dto.nome();
        this.email = dto.email();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
