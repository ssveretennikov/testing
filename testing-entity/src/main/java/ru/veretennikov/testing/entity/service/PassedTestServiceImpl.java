package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.PassedTest;
import ru.veretennikov.testing.entity.db.Question;
import ru.veretennikov.testing.entity.db.Test;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestUpdateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Response.PassedTestResponseDTO;
import ru.veretennikov.testing.entity.mapper.PassedTestDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.PassedTestRepository;
import ru.veretennikov.testing.entity.repository.TestRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PassedTestServiceImpl implements PassedTestService {

    private final PassedTestRepository repository;
    private final TestRepository testRepository;
    private final PassedTestDtoEntityMapper mapper;

    @Override
    public PassedTestResponseDTO findById(Long id) {
        return mapper.toDTO(getById(id));
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

        Test test = testRepository.findById(createDTO.getTestId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Не найдена запись в таблице тестов с id %d", createDTO.getTestId())));
        passedTest.setTest(test);

        PassedTest result = repository.save(passedTest);
        return mapper.toDTO(result);
    }

    @Override
    public PassedTestResponseDTO update(Long id, PassedTestUpdateDTO updateDTO) {
        if (updateDTO == null)
            throw new IllegalArgumentException("Нечего обновлять");

        PassedTest passedTest = getById(id);
        if (updateDTO.getUserName() != null)
            passedTest.setUserName(updateDTO.getUserName());
        if (updateDTO.getDateStart() != null)
            passedTest.setDateStart(updateDTO.getDateStart());
        if (updateDTO.getDateEnd() != null)
            passedTest.setDateEnd(updateDTO.getDateEnd());

        PassedTest result = repository.save(passedTest);
        return mapper.toDTO(result);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private PassedTest getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Не найдена запись с id %d", id)));
    }

}
