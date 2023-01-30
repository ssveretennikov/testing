package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.Answer;
import ru.veretennikov.testing.entity.db.PassedTest;
import ru.veretennikov.testing.entity.db.Question;
import ru.veretennikov.testing.entity.db.UserAnswer;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Response.UserAnswerResponseDTO;
import ru.veretennikov.testing.entity.exception.EntityNotFoundException;
import ru.veretennikov.testing.entity.mapper.UserAnswerDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.AnswerRepository;
import ru.veretennikov.testing.entity.repository.PassedTestRepository;
import ru.veretennikov.testing.entity.repository.QuestionRepository;
import ru.veretennikov.testing.entity.repository.UserAnswerRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {

    private final UserAnswerRepository repository;
    private final PassedTestRepository passedTestRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserAnswerDtoEntityMapper mapper;

    @Override
    public UserAnswerResponseDTO findById(Long id) {
        return mapper.toDTO(getById(id));
    }

    @Override
    public List<UserAnswerResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserAnswerResponseDTO create(UserAnswerCreateDTO createDTO) {
        UserAnswer userAnswer = mapper.toEntity(createDTO);

        PassedTest passedTest = passedTestRepository.findById(createDTO.getPassedTestId())
                .orElseThrow(() -> new EntityNotFoundException(format("Не найдена запись в таблице пройденных тестов с id %d", createDTO.getPassedTestId())));
        userAnswer.setPassedTest(passedTest);
        Question question = questionRepository.findById(createDTO.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException(format("Не найдена запись в таблице вопросов с id %d", createDTO.getQuestionId())));
        userAnswer.setQuestion(question);
        Answer answer = answerRepository.findById(createDTO.getAnswerId())
                .orElseThrow(() -> new EntityNotFoundException(format("Не найдена запись в таблице ответов с id %d", createDTO.getAnswerId())));
        userAnswer.setAnswer(answer);

        UserAnswer result = repository.save(userAnswer);
        return mapper.toDTO(result);
    }

    @Override
    public UserAnswerResponseDTO update(Long id, UserAnswerUpdateDTO updateDTO) {
        if (updateDTO == null)
            throw new IllegalArgumentException("Нечего обновлять");

        UserAnswer userAnswer = getById(id);
        if (updateDTO.getDescription() != null)
            userAnswer.setDescription(updateDTO.getDescription());
        if (updateDTO.getLeftPart() != null)
            userAnswer.setLeftPart(updateDTO.getLeftPart());

        UserAnswer result = repository.save(userAnswer);
        return mapper.toDTO(result);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private UserAnswer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("Не найдена запись с id %d", id)));
    }

}
