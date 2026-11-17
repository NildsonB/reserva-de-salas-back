package com.reserva_de_salas.domain.dto;

import java.util.UUID;

public record AtualizaCadastroSalaDto(UUID id, String nome, Integer capacidade) {
}
