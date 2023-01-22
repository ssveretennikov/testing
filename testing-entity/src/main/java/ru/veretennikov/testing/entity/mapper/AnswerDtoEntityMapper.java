package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.veretennikov.testing.entity.db.Answer;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Response.AnswerResponseDTO;

/**
 * Маппер dto и entity Answer
 */
@Mapper(componentModel = "spring")
public interface AnswerDtoEntityMapper {

    @Mappings({
            @Mapping(target = "questionId", source = "question.id"),
    })
    AnswerResponseDTO toDTO(Answer source);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "question", ignore = true),
    })
    Answer toEntity(AnswerCreateDTO source);

}
