package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.Test;
import ru.veretennikov.testing.entity.dto.TestDTO.Request.TestCreateDTO;
import ru.veretennikov.testing.entity.dto.TestDTO.Request.TestUpdateDTO;
import ru.veretennikov.testing.entity.dto.TestDTO.Response.TestResponseDTO;
import ru.veretennikov.testing.entity.exception.EntityNotFoundException;
import ru.veretennikov.testing.entity.mapper.TestDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.TestRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository repository;
    private final TestDtoEntityMapper mapper;

    @Override
    public TestResponseDTO findById(Long id) {
        return mapper.toDTO(getById(id));
    }

    @Override
    public List<TestResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TestResponseDTO create(TestCreateDTO createDTO) {
        Test test = mapper.toEntity(createDTO);
        Test result = repository.save(test);
        return mapper.toDTO(result);
    }

    @Override
    public TestResponseDTO update(Long id, TestUpdateDTO updateDTO) {
        if (updateDTO == null)
            throw new IllegalArgumentException("Нечего обновлять");

        Test test = getById(id);
        if (updateDTO.getAuthor() != null)
            test.setAuthor(updateDTO.getAuthor());
        if (updateDTO.getName() != null)
            test.setName(updateDTO.getName());
        if (updateDTO.getUploadDate() != null)
            test.setUploadDate(updateDTO.getUploadDate());

        Test result = repository.save(test);
        return mapper.toDTO(result);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Test getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("Не найдена запись с id %d", id)));
    }

}
