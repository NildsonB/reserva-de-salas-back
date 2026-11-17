package com.reserva_de_salas.domain.validations;

import com.reserva_de_salas.domain.exception.ValidacaoException;
import com.reserva_de_salas.domain.model.Reserva;

import java.time.Duration;

public class ValidacaoPeriodoReserva {

    public void validarPeriodoReserva(Reserva reserva){
        Duration tempoDeReserva = Duration.between(reserva.getInicio(), reserva.getFim());
        Duration tempoMinimo = Duration.ofHours(1);
        int comparacao = tempoDeReserva.compareTo(tempoMinimo);
        if(comparacao < 0){
            throw new ValidacaoException("O tempo mínimo para reserva é de 1H.");
        }
    }
}
