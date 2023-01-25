package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.Answer;
import ru.veretennikov.testing.entity.db.Question;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Response.AnswerResponseDTO;
import ru.veretennikov.testing.entity.mapper.AnswerDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.AnswerRepository;
import ru.veretennikov.testing.entity.repository.QuestionRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;
    private final QuestionRepository questionRepository;
    private final AnswerDtoEntityMapper mapper;

    @Override
    public AnswerResponseDTO findById(Long id) {
        return mapper.toDTO(getById(id));
    }

    @Override
    public List<AnswerResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerResponseDTO create(AnswerCreateDTO createDTO) {
        Answer answer = mapper.toEntity(createDTO);

        Question question = questionRepository.findById(createDTO.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Не найдена запись в таблице вопросов с id %d", createDTO.getQuestionId())));
        answer.setQuestion(question);

        Answer result = repository.save(answer);
        return mapper.toDTO(result);
    }

    @Override
    public AnswerResponseDTO update(Long id, AnswerUpdateDTO updateDTO) {
        if (updateDTO == null)
            throw new IllegalArgumentException("Нечего обновлять");

        Answer answer = getById(id);
        if (updateDTO.getDescription() != null)
            answer.setDescription(updateDTO.getDescription());
        if (updateDTO.getLeftPart() != null)
            answer.setLeftPart(updateDTO.getLeftPart());
        if (updateDTO.getCorrect() != null)
            answer.setCorrect(updateDTO.getCorrect());
        if (updateDTO.getOrderNumber() != null)
            answer.setOrderNumber(updateDTO.getOrderNumber());

        Answer result = repository.save(answer);
        return mapper.toDTO(result);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Answer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Не найдена запись с id %d", id)));
    }

}
