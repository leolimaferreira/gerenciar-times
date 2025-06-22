package com.gerenciartimes.dto;

public record CadastroJogadorDTO(
        String nome,
        String nascimento,
        String posicao,
        double valor,
        double pontuacao,
        Long timeId,
        Long escalacaoId
) {
}
