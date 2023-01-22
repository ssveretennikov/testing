package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.veretennikov.testing.entity.db.Test;
import ru.veretennikov.testing.entity.dto.TestDTO.Request.TestCreateDTO;
import ru.veretennikov.testing.entity.dto.TestDTO.Response.TestResponseDTO;

/**
 * Маппер dto и entity Test
 */
@Mapper(componentModel = "spring")
public interface TestDtoEntityMapper {

    TestResponseDTO toDTO(Test source);

    @Mapping(target = "id", ignore = true)
    Test toEntity(TestCreateDTO source);

}
