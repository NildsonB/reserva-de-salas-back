package com.reserva_de_salas.domain.validations;

import com.reserva_de_salas.domain.dto.CadastroSalaDto;
import com.reserva_de_salas.domain.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidarCapacidadeSala {

    public void validar(CadastroSalaDto dto){
        if (dto.capacidade() < 1){
            throw new ValidacaoException("A capacidade da sala deve ser maior que 0.");
        }
    }
}
