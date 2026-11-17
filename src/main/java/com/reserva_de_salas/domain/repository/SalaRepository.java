package com.reserva_de_salas.domain.repository;

import com.reserva_de_salas.domain.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
    Sala findById(UUID id);
}
