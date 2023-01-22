package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import ru.veretennikov.testing.entity.db.Answer;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Request.AnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Response.AnswerResponseDTO;

/**
 * Маппер dto и entity Answer
 */
@Mapper(componentModel = "spring")
public interface AnswerDtoEntityMapper {
    AnswerResponseDTO toDto(Answer source);
    Answer toEntity(AnswerCreateDTO source);
    Answer toEntity(AnswerUpdateDTO source);
}


