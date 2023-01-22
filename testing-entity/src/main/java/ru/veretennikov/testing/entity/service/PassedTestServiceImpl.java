package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Request.PassedTestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Response.PassedTestResponseDTO;
import ru.veretennikov.testing.entity.repository.PassedTestRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassedTestServiceImpl implements PassedTestService {

    private final PassedTestRepository repository;

    @Override
    public PassedTestResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<PassedTestResponseDTO> findAll() {
        return null;
    }

    @Override
    public PassedTestResponseDTO create(PassedTestCreateDTO createDTO) {
        return null;
    }

    @Override
    public PassedTestResponseDTO update(PassedTestUpdateDTO updateDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
