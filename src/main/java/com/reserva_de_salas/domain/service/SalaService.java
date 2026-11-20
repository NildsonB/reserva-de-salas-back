package com.reserva_de_salas.domain.service;

import com.reserva_de_salas.domain.dto.*;
import com.reserva_de_salas.domain.model.Sala;
import com.reserva_de_salas.domain.repository.SalaRepository;
import com.reserva_de_salas.domain.validations.ValidarCapacidadeSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalaService {

    @Autowired
    private ValidarCapacidadeSala validarCapacidade;

    @Autowired
    private SalaRepository repository;

    public List<SalaDto> listarSalas() {
        List<Sala> salas = repository.findAll();
        return salas.stream()
                .map(s -> new SalaDto(s.getId(), s.getNome(), s.getCapacidade(), s.isAtiva()))
                .toList();
    }

    public List<SalaDto> buscarSalaPorNome(String nome) {
        List<Sala> sala = repository.findByNomeContainsIgnoreCase(nome);
        return sala.stream()
                .map(s -> new SalaDto(s.getId(), s.getNome(), s.getCapacidade(), s.isAtiva()))
                .toList();
    }

    public void cadastrarSala(CadastroSalaDto dto){
        validarCapacidade.validar(dto);
        Sala sala = new Sala(dto);
        repository.save(sala);
    }

    public void atualizarSala(AtualizaCadastroSalaDto dto){
        Sala sala = repository.findById(dto.id());
        sala.atualizarDados(dto);
        repository.save(sala);
    }

    public void alterarStatusSala(UUID id){
        Sala sala = repository.findById(id);
        sala.alterarStatus();
        repository.save(sala);
    }

    public void deletarSala(UUID id) {
        Sala sala = repository.findById(id);
        repository.delete(sala);
    }
}
