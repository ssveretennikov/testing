package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Response.TestResponseDTO;
import ru.veretennikov.testing.entity.repository.TestRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository repository;

    @Override
    public TestResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<TestResponseDTO> findAll() {
        return null;
    }

    @Override
    public TestResponseDTO create(TestCreateDTO createDTO) {
        return null;
    }

    @Override
    public TestResponseDTO update(TestUpdateDTO updateDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
