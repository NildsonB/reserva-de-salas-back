package com.reserva_de_salas.domain.validations;

import com.reserva_de_salas.domain.exception.ValidacaoException;
import com.reserva_de_salas.domain.model.Reserva;
import com.reserva_de_salas.domain.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidarSobreposição {

    @Autowired
    private ReservaRepository reservaRepository;

    public void validar(Reserva reserva) {
        boolean inicioExistente = reservaRepository.existsByInicio(reserva.getInicio());
        boolean fimExistente = reservaRepository.existsByFim(reserva.getFim());

        if (inicioExistente) {
            throw new ValidacaoException("O horário de início está chocando com outro horário de reserva.");
        }

        if (fimExistente) {
            throw new ValidacaoException("O horário de fim está chocando com outro horário de reserva.");
        }
    }
}
