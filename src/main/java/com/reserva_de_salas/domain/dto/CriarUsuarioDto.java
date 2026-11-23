package com.reserva_de_salas.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CriarUsuarioDto(@NotBlank String nome, @NotBlank @Email String email) {
}
