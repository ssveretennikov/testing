package ru.veretennikov.testing.entity.service;

import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Response.UserAnswerResponseDTO;

import java.util.List;

public interface UserAnswerService {
    UserAnswerResponseDTO findById(Long id);
    List<UserAnswerResponseDTO> findAll();
    UserAnswerResponseDTO create(UserAnswerCreateDTO createDTO);
    UserAnswerResponseDTO update(Long id, UserAnswerUpdateDTO updateDTO);
    void delete(Long id);
}
