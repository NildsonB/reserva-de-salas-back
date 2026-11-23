package com.reserva_de_salas.domain.controller;

import com.reserva_de_salas.domain.dto.CriarUsuarioDto;
import com.reserva_de_salas.domain.dto.UsuarioDto;
import com.reserva_de_salas.domain.exception.ValidacaoException;
import com.reserva_de_salas.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioDto>> listarUsuariosPorNome(@RequestParam String nome) {
        try {
            return new ResponseEntity<>(usuarioService.buscarUsuarioPorNome(nome), HttpStatus.OK);
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuarioService.listarUsuarios());
        }
    }

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody @Valid CriarUsuarioDto dto) {
        try {
            usuarioService.criarUsuario(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizarUsuario(@PathVariable @Valid UsuarioDto dto) {
        try {
            usuarioService.atualizarUsuario(dto);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario atualizado com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable @Valid UUID id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
