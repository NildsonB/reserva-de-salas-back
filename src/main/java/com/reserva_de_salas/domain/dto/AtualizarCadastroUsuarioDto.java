package com.reserva_de_salas.domain.dto;

import java.util.UUID;

public record AtualizarCadastroUsuarioDto(UUID id, String nome, String email) {
}
