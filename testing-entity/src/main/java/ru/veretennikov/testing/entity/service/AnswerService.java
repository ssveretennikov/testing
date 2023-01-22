package ru.veretennikov.testing.entity.service;

import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Response.AnswerResponseDTO;

import java.util.List;

public interface AnswerService {
    AnswerResponseDTO findById(Long id);
    List<AnswerResponseDTO> findAll();
    AnswerResponseDTO create(AnswerCreateDTO createDTO);
    AnswerResponseDTO update(Long id, AnswerUpdateDTO updateDTO);
    void delete(Long id);
}
