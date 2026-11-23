package com.reserva_de_salas.domain.controller;

import com.reserva_de_salas.domain.dto.ReservaDto;
import com.reserva_de_salas.domain.exception.ValidacaoException;
import com.reserva_de_salas.domain.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservas;

    @PostMapping
    public ResponseEntity<String> reservarSala(@Valid @RequestBody ReservaDto dto) {
        try {
            reservas.reservarSala(dto);
            return ResponseEntity.status(HttpStatus.OK).body("Sala reservada com sucesso!");
        } catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
