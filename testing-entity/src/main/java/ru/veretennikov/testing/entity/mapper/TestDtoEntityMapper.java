package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import ru.veretennikov.testing.entity.db.Test;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Response.TestResponseDTO;

/**
 * Маппер dto и entity Test
 */
@Mapper(componentModel = "spring")
public interface TestDtoEntityMapper {
    TestResponseDTO toDto(Test source);
    Test toEntity(TestCreateDTO source);
    Test toEntity(TestUpdateDTO source);
}


