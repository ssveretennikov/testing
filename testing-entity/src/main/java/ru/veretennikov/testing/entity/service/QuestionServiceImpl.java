package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.Question;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Request.QuestionUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Response.QuestionResponseDTO;
import ru.veretennikov.testing.entity.mapper.QuestionDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.QuestionRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    private final QuestionDtoEntityMapper mapper;

    @Override
    public QuestionResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<QuestionResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponseDTO create(QuestionCreateDTO createDTO) {
        Question answer = mapper.toEntity(createDTO);
        Question result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public QuestionResponseDTO update(QuestionUpdateDTO updateDTO) {
        Question answer = mapper.toEntity(updateDTO);
        Question result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
