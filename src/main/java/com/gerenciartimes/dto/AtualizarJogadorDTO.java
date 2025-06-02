package com.gerenciartimes.dto;

public record AtualizarJogadorDTO(
        String nome,
        String nascimento,
        String posicao,
        Long timeId
) {
}
