package com.reserva_de_salas.domain.service;

import com.reserva_de_salas.domain.dto.ReservaDto;
import com.reserva_de_salas.domain.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservas;

    public void reservarSala(ReservaDto dto) {

    }
}
