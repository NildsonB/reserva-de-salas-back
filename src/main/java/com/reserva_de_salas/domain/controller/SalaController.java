package com.reserva_de_salas.domain.controller;

import com.reserva_de_salas.domain.dto.AtualizaCadastroSalaDto;
import com.reserva_de_salas.domain.dto.CadastroSalaDto;
import com.reserva_de_salas.domain.dto.SalaDto;
import com.reserva_de_salas.domain.exception.ValidacaoException;
import com.reserva_de_salas.domain.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/salas")
public class SalaController {

    @Autowired
    private SalaService salas;

    @GetMapping
    public ResponseEntity<List<SalaDto>> listarSalas() {
        return new ResponseEntity<>(salas.listarSalas(), HttpStatus.OK);
    }

    @GetMapping("{nome}")
    public ResponseEntity<List<SalaDto>> buscarSalasPorNome(@PathVariable String nome) {
        try {
            return new ResponseEntity<>(salas.buscarSalaPorNome(nome), HttpStatus.OK);
        } catch (ValidacaoException e) {
            return new ResponseEntity<>(new ArrayList<SalaDto>(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrarSala(@RequestBody CadastroSalaDto dto) {
        try {
            salas.cadastrarSala(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sala cadastrada com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizarSala(@RequestBody AtualizaCadastroSalaDto dto) {
        try {
            salas.atualizarSala(dto);
            return ResponseEntity.status(HttpStatus.OK).body("Sala atualizada com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> alterarStatusSala(@PathVariable UUID id) {
        try {
            salas.alterarStatusSala(id);
            return ResponseEntity.status(HttpStatus.OK).body("Status alterado com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removerSala(@PathVariable UUID id) {
        try {
            salas.deletarSala(id);
            return ResponseEntity.status(HttpStatus.OK).body("Sala removida com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

