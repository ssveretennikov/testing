package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import ru.veretennikov.testing.entity.db.PassedTest;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Request.PassedTestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Response.PassedTestResponseDTO;

/**
 * Маппер dto и entity PassedTest
 */
@Mapper(componentModel = "spring")
public interface PassedTestDtoEntityMapper {
    PassedTestResponseDTO toDto(PassedTest source);
    PassedTest toEntity(PassedTestCreateDTO source);
    PassedTest toEntity(PassedTestUpdateDTO source);
}


