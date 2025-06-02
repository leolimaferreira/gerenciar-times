package com.gerenciartimes;

import com.gerenciartimes.dto.CadastroTimeDTO;
import com.gerenciartimes.entity.Time;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeMapper {

    Time toEntity(CadastroTimeDTO dto);

    CadastroTimeDTO toDto(Time entity);
}
