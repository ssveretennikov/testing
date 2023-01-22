package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.PassedTest;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Request.PassedTestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.PassedTestDTO.Response.PassedTestResponseDTO;
import ru.veretennikov.testing.entity.mapper.PassedTestDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.PassedTestRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PassedTestServiceImpl implements PassedTestService {

    private final PassedTestRepository repository;
    private final PassedTestDtoEntityMapper mapper;

    @Override
    public PassedTestResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<PassedTestResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PassedTestResponseDTO create(PassedTestCreateDTO createDTO) {
        PassedTest answer = mapper.toEntity(createDTO);
        PassedTest result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public PassedTestResponseDTO update(PassedTestUpdateDTO updateDTO) {
        PassedTest answer = mapper.toEntity(updateDTO);
        PassedTest result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
