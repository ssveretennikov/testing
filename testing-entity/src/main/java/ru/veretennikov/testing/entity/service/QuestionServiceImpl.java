package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.Question;
import ru.veretennikov.testing.entity.db.Test;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionUpdateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Response.QuestionResponseDTO;
import ru.veretennikov.testing.entity.mapper.QuestionDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.QuestionRepository;
import ru.veretennikov.testing.entity.repository.TestRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    private final TestRepository testRepository;
    private final QuestionDtoEntityMapper mapper;

    @Override
    public QuestionResponseDTO findById(Long id) {
        return mapper.toDTO(getById(id));
    }

    @Override
    public List<QuestionResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponseDTO create(QuestionCreateDTO createDTO) {
        Question question = mapper.toEntity(createDTO);

        Test test = testRepository.findById(createDTO.getTestId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Не найдена запись в таблице тестов с id %d", createDTO.getTestId())));
        question.setTest(test);

        // TODO: проверить, запишутся ли ответы вместе с вопросом
        Question result = repository.save(question);
        return mapper.toDTO(result);
    }

    @Override
    public QuestionResponseDTO update(Long id, QuestionUpdateDTO updateDTO) {
        if (updateDTO == null)
            throw new IllegalArgumentException("Нечего обновлять");

        Question question = getById(id);
        if (updateDTO.getDescription() != null)
            question.setDescription(updateDTO.getDescription());
        if (updateDTO.getWeight() != null)
            question.setWeight(updateDTO.getWeight());
        if (updateDTO.getType() != null)
            question.setType(updateDTO.getType());
        if (updateDTO.getOrderNumber() != null)
            question.setOrderNumber(updateDTO.getOrderNumber());

        Question result = repository.save(question);
        return mapper.toDTO(result);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Question getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Не найдена запись с id %d", id)));
    }

}
