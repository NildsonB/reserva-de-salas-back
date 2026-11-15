package com.reserva_de_salas.domain.validations;

import com.reserva_de_salas.domain.exception.ValidacaoException;
import com.reserva_de_salas.domain.model.Reserva;

public class ValidarSalaAtiva {

    public void validarSalaAtiva(Reserva reserva){
        if(!reserva.getSala().isAtiva()){
            throw new ValidacaoException("A sala deve estar ativa para reservar!");
        }
    }
}
