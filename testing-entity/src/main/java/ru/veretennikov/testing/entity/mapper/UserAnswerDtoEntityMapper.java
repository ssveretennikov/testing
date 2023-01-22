package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import ru.veretennikov.testing.entity.db.UserAnswer;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Request.UserAnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Response.UserAnswerResponseDTO;

/**
 * Маппер dto и entity Answer
 */
@Mapper(componentModel = "spring")
public interface UserAnswerDtoEntityMapper {
    UserAnswerResponseDTO toDto(UserAnswer source);
    UserAnswer toEntity(UserAnswerCreateDTO source);
    UserAnswer toEntity(UserAnswerUpdateDTO source);
}


