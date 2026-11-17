package com.reserva_de_salas.domain.repository;

import com.reserva_de_salas.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
