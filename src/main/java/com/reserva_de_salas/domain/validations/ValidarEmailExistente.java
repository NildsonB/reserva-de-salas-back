package com.reserva_de_salas.domain.validations;

import com.reserva_de_salas.domain.dto.CriarUsuarioDto;
import com.reserva_de_salas.domain.exception.ValidacaoException;
import com.reserva_de_salas.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarEmailExistente {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(CriarUsuarioDto dto) {
        if (usuarioRepository.existsByEmail(dto.email())){
            throw new ValidacaoException("E-mail já cadastrado!");
        }
    }
}
