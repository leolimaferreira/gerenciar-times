package com.gerenciartimes.controller;

import com.gerenciartimes.mapper.TimeMapper;
import com.gerenciartimes.dto.CadastroTimeDTO;
import com.gerenciartimes.entity.Time;
import com.gerenciartimes.service.TimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;
    private final TimeMapper timeMapper;

    @PostMapping
    public void salvar(@RequestBody @Valid CadastroTimeDTO dto) {
        Time time = timeMapper.toEntity(dto);
        timeService.salvar(time);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        timeService.deletar(id);
    }

    @GetMapping
    public List<Time> listar() {
        return timeService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Time> buscarPorId(@PathVariable Long id) {
        return timeService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@RequestBody @Valid CadastroTimeDTO dto, @PathVariable Long id) {
        Optional<Time> optionalTime = timeService.buscarPorId(id);

        Time time = optionalTime.get();
        time.setNome(dto.nome());
        time.setCidade(dto.cidade());
        time.setEstado(dto.estado());
        time.setEstadio(dto.estadio());

        timeService.atualizar(time);
    }

}
