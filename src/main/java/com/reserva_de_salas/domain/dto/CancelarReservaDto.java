package com.reserva_de_salas.domain.dto;

import com.reserva_de_salas.domain.model.Sala;
import com.reserva_de_salas.domain.model.Usuario;

import java.time.LocalDate;
import java.util.UUID;

public record CancelarReservaDto(UUID id) {
}
