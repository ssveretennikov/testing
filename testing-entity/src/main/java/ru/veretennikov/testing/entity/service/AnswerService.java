package ru.veretennikov.testing.entity.service;

import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Request.AnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Response.AnswerResponseDTO;

import java.util.List;

public interface AnswerService {
    AnswerResponseDTO findById(Long id);
    List<AnswerResponseDTO> findAll();
    AnswerResponseDTO create(AnswerCreateDTO createDTO);
    AnswerResponseDTO update(AnswerUpdateDTO updateDTO);
    void delete(Long id);
}
