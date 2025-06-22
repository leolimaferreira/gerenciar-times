package com.gerenciartimes.mapper;

import com.gerenciartimes.dto.CadastroJogadorDTO;
import com.gerenciartimes.entity.Jogador;
import com.gerenciartimes.repository.TimeRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class JogadorMapper {

    @Autowired
    TimeRepository timeRepository;


    @Mapping(target = "time", expression = "java(timeRepository.findById(dto.timeId()).orElse(null))")
    public abstract Jogador toEntity(CadastroJogadorDTO dto);

    public abstract CadastroJogadorDTO toDto(Jogador jogador);
}
