package com.reserva_de_salas.domain.repository;

import com.reserva_de_salas.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
}
