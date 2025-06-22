package com.gerenciartimes.repository;

import com.gerenciartimes.entity.Jogador;
import com.gerenciartimes.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    List<Jogador> findAllByTimeId(Long timeId);

    long countByTime(Time time);

    List<Jogador> findByPosicao(String posicao);

    @Query(value = "CALL listarTodosJogadores()", nativeQuery = true)
    List<Jogador> listarTodosViaProcedure();
}
