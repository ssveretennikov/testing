package ru.veretennikov.testing.entity.service;

import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Request.PassedTestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Response.PassedTestResponseDTO;

import java.util.List;

public interface PassedTestService {
    PassedTestResponseDTO findById(Long id);
    List<PassedTestResponseDTO> findAll();
    PassedTestResponseDTO create(PassedTestCreateDTO createDTO);
    PassedTestResponseDTO update(PassedTestUpdateDTO updateDTO);
    void delete(Long id);
}
