package com.reserva_de_salas.domain.repository;

import com.reserva_de_salas.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, UUID> {

    @Query("SELECT EXISTS( SELECT 1 FROM Reserva r WHERE :inicio BETWEEN  r.inicio AND r.fim AND r.status = TRUE)")
    boolean existsByInicio(LocalTime inicio);

    @Query("SELECT EXISTS( SELECT 1 FROM Reserva r WHERE :fim BETWEEN  r.inicio AND  r.fim AND r.status = TRUE)")
    boolean existsByFim(LocalTime fim);
}
