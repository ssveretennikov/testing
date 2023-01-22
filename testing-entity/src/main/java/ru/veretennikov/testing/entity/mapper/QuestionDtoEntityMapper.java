package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.veretennikov.testing.entity.db.Question;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Response.QuestionResponseDTO;

/**
 * Маппер dto и entity Question
 */
@Mapper(componentModel = "spring", uses = AnswerDtoEntityMapper.class)
public interface QuestionDtoEntityMapper {

    @Mappings({
            @Mapping(target = "testId", source = "test.id"),
    })
    QuestionResponseDTO toDTO(Question source);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "test", ignore = true),
            @Mapping(target = "answers", ignore = true),
    })
    Question toEntity(QuestionCreateDTO source);

}
