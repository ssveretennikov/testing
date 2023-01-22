package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.veretennikov.testing.entity.db.UserAnswer;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Response.UserAnswerResponseDTO;

/**
 * Маппер dto и entity Answer
 */
@Mapper(componentModel = "spring")
public interface UserAnswerDtoEntityMapper {

    @Mappings({
            @Mapping(target = "passedTestId", source = "passedTest.id"),
            @Mapping(target = "questionId", source = "question.id"),
            @Mapping(target = "answerId", source = "answer.id"),
    })
    UserAnswerResponseDTO toDTO(UserAnswer source);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "passedTest", ignore = true),
            @Mapping(target = "question", ignore = true),
            @Mapping(target = "answer", ignore = true),
    })
    UserAnswer toEntity(UserAnswerCreateDTO source);

}
