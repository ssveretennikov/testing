package ru.veretennikov.testing.entity.service;

import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionUpdateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Response.QuestionResponseDTO;

import java.util.List;

public interface QuestionService {
    QuestionResponseDTO findById(Long id);
    List<QuestionResponseDTO> findAll();
    QuestionResponseDTO create(QuestionCreateDTO createDTO);
    QuestionResponseDTO update(Long id, QuestionUpdateDTO updateDTO);
    void delete(Long id);
}
