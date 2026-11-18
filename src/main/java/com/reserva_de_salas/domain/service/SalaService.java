package com.reserva_de_salas.domain.service;

import com.reserva_de_salas.domain.dto.*;
import com.reserva_de_salas.domain.model.Sala;
import com.reserva_de_salas.domain.repository.SalaRepository;
import com.reserva_de_salas.domain.validations.ValidarCapacidadeSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public SalaDto buscarSalaPorNome(String nome) {
        Sala sala = repository.findByNomeContainsIgnoreCase(nome);
        return new SalaDto(sala.getId(), sala.getNome(), sala.getCapacidade(), sala.isAtiva());
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

    public void alterarStatusSala(AlterarStatusSalaDto dto){
        Sala sala = repository.findById(dto.id());
        sala.alterarStatus();
        repository.save(sala);
    }

    public void deletarSala(DeletarSalaDto dto) {
        Sala sala = repository.findById(dto.id());
        repository.delete(sala);
    }
}
