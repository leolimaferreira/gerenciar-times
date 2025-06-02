package com.gerenciartimes.service;

import com.gerenciartimes.entity.Jogador;
import com.gerenciartimes.entity.Time;
import com.gerenciartimes.repository.JogadorRepository;
import com.gerenciartimes.repository.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final TimeRepository timeRepository;

    public void salvar(Jogador jogador) {
        Time time = timeRepository.findById(jogador.getTime().getId())
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));

        long totalJogadores = jogadorRepository.countByTime(time);

        if (totalJogadores == 11) {
            throw new RuntimeException("O time já possui 11 jogadores.");
        }

        jogadorRepository.save(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.deleteById(id);
    }

    public Optional<Jogador> findById(Long id) {
        return jogadorRepository.findById(id);
    }

    public void atualizar(Jogador jogador) {
        jogadorRepository.save(jogador);
    }
}
