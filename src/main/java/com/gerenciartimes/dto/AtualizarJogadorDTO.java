package com.gerenciartimes.dto;

public record AtualizarJogadorDTO(
        String nome,
        String nascimento,
        String posicao,
        double valor,
        double pontuacao,
        Long timeId
) {
}
