package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.Test;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Response.TestResponseDTO;
import ru.veretennikov.testing.entity.mapper.TestDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.TestRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository repository;
    private final TestDtoEntityMapper mapper;

    @Override
    public TestResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<TestResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TestResponseDTO create(TestCreateDTO createDTO) {
        Test answer = mapper.toEntity(createDTO);
        Test result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public TestResponseDTO update(TestUpdateDTO updateDTO) {
        Test answer = mapper.toEntity(updateDTO);
        Test result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
