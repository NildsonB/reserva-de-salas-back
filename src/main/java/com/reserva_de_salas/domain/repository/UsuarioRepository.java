package com.reserva_de_salas.domain.repository;

import com.reserva_de_salas.domain.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    boolean existsByEmail(String email);

    List<Usuario> findByNomeContainsIgnoreCase(String nome);
}
