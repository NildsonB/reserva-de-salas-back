package com.reserva_de_salas.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UsuarioDto(UUID id, @NotBlank String nome, @NotBlank @Email String email) {}

