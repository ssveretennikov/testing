package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.PassedTest;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestUpdateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Response.PassedTestResponseDTO;
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
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<PassedTestResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PassedTestResponseDTO create(PassedTestCreateDTO createDTO) {
        PassedTest passedTest = mapper.toEntity(createDTO);
        PassedTest result = repository.save(passedTest);
        return mapper.toDTO(result);
    }

    @Override
    public PassedTestResponseDTO update(Long id, PassedTestUpdateDTO updateDTO) {
//        PassedTest passedTest = mapper.toEntity(updateDTO);
//        PassedTest result = repository.save(passedTest);
//        return mapper.toDTO(result);
        return null;        // exception
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
