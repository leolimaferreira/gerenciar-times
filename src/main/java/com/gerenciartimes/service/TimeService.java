package com.gerenciartimes.service;

import com.gerenciartimes.entity.Time;
import com.gerenciartimes.repository.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeRepository timeRepository;

    public void salvar(Time time) {
        timeRepository.save(time);
    }

    public void deletar(Long id) {
        timeRepository.deleteById(id);
    }

    public List<Time> listar() {
        return timeRepository.findAll();
    }

    public Optional<Time> buscarPorId(Long id) {
        return timeRepository.findById(id);
    }

    public void atualizar(Time time) { timeRepository.save(time); }
}
