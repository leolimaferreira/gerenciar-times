package com.gerenciartimes.controller;

import com.gerenciartimes.dto.AtualizarJogadorDTO;
import com.gerenciartimes.dto.CadastroJogadorDTO;
import com.gerenciartimes.entity.Jogador;
import com.gerenciartimes.entity.Time;
import com.gerenciartimes.mapper.JogadorMapper;
import com.gerenciartimes.service.JogadorService;
import com.gerenciartimes.service.TimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;
    private final TimeService timeService;
    private final JogadorMapper jogadorMapper;

    @PostMapping
    public void salvar(@RequestBody @Valid CadastroJogadorDTO dto) {

        Optional<Time> timeOptional = timeService.buscarPorId(dto.timeId());
        Jogador jogador = jogadorMapper.toEntity(dto);

        if (timeOptional.isPresent()) {
            Time time = timeOptional.get();
            jogador.setTime(time);
            jogadorService.salvar(jogador);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { jogadorService.deletar(id);}

    @GetMapping("/{id}")
    public Optional<Jogador> buscarPorId(@PathVariable Long id) {
        return jogadorService.findById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@RequestBody @Valid AtualizarJogadorDTO dto, @PathVariable Long id) {
        Optional<Jogador> optionalJogador = jogadorService.findById(id);

        Jogador jogador = optionalJogador.get();
        jogador.setNome(dto.nome());
        jogador.setNascimento(dto.nascimento());
        jogador.setPosicao(dto.posicao());
        jogador.setValor(dto.valor());
        jogador.setPontuacao(dto.pontuacao());
        jogador.setTime(timeService.buscarPorId(dto.timeId()).get());

        jogadorService.atualizar(jogador);
    }

    @GetMapping("/time/{timeId}")
    public List<Jogador> buscarPorTimeId(@PathVariable Long timeId) {
        return jogadorService.buscarJogadoresPorTime(timeId);
    }

    @GetMapping()
    public List<Jogador> buscarTodosPorProcedure() {
        return jogadorService.buscarJogadoresPorProcedure();
    }
}
