package com.reserva_de_salas.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.UUID;

public record ReservaDto(@NotNull UUID idSala, @NotNull UUID idUsuario, @NotBlank LocalTime inicio, @NotBlank LocalTime fim
) {
}
