package com.reserva_de_salas.domain.service;

import com.reserva_de_salas.domain.dto.CriarUsuarioDto;
import com.reserva_de_salas.domain.dto.UsuarioDto;
import com.reserva_de_salas.domain.model.Usuario;
import com.reserva_de_salas.domain.repository.UsuarioRepository;
import com.reserva_de_salas.domain.validations.ValidarEmailExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidarEmailExistente validarEmail;

    public void criarUsuario(CriarUsuarioDto dto) {
        validarEmail.validar(dto);
        Usuario usuario = new Usuario(dto);
        usuarioRepository.save(usuario);
    }

    public List<UsuarioDto> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(u -> new UsuarioDto(u.getId(), u.getNome(), u.getEmail()))
                .collect(Collectors.toList());
    }

    public void atualizarUsuario(UsuarioDto dto) {
        Usuario usuario = usuarioRepository.getReferenceById(dto.id());
        usuario.atualizar(dto);
        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(UUID id) {
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioDto> buscarUsuarioPorNome(String nome) {
        List<Usuario> usuarios = usuarioRepository.findByNomeContainsIgnoreCase(nome);
        return usuarios.stream()
                .map(u -> new UsuarioDto(u.getId(), u.getNome(), u.getEmail()))
                .collect(Collectors.toList());
    }
}
