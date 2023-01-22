package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.veretennikov.testing.entity.db.PassedTest;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Response.PassedTestResponseDTO;

/**
 * Маппер dto и entity PassedTest
 */
@Mapper(componentModel = "spring")
public interface PassedTestDtoEntityMapper {

    @Mappings({
            @Mapping(target = "testId", source = "test.id"),
    })
    PassedTestResponseDTO toDTO(PassedTest source);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "test", ignore = true),
    })
    PassedTest toEntity(PassedTestCreateDTO source);

}
