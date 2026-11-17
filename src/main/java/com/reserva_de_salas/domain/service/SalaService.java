package com.reserva_de_salas.domain.service;

import com.reserva_de_salas.domain.dto.AlterarStatusSalaDto;
import com.reserva_de_salas.domain.dto.AtualizaCadastroSalaDto;
import com.reserva_de_salas.domain.dto.CadastroSalaDto;
import com.reserva_de_salas.domain.model.Sala;
import com.reserva_de_salas.domain.repository.SalaRepository;
import com.reserva_de_salas.domain.validations.ValidarCapacidadeSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {

    @Autowired
    private ValidarCapacidadeSala validarCapacidade;

    @Autowired
    private SalaRepository repository;

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
}
