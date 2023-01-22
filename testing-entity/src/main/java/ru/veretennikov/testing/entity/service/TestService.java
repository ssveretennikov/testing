package ru.veretennikov.testing.entity.service;

import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Response.TestResponseDTO;

import java.util.List;

public interface TestService {
    TestResponseDTO findById(Long id);
    List<TestResponseDTO> findAll();
    TestResponseDTO create(TestCreateDTO createDTO);
    TestResponseDTO update(TestUpdateDTO updateDTO);
    void delete(Long id);
}
