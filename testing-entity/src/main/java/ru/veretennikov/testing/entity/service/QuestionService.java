package ru.veretennikov.testing.entity.service;

import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Request.QuestionUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Response.QuestionResponseDTO;

import java.util.List;

public interface QuestionService {
    QuestionResponseDTO findById(Long id);
    List<QuestionResponseDTO> findAll();
    QuestionResponseDTO create(QuestionCreateDTO createDTO);
    QuestionResponseDTO update(QuestionUpdateDTO updateDTO);
    void delete(Long id);
}
