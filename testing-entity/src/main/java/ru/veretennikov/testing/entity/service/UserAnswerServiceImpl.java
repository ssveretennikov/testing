package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.UserAnswer;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Response.UserAnswerResponseDTO;
import ru.veretennikov.testing.entity.mapper.UserAnswerDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.UserAnswerRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {

    private final UserAnswerRepository repository;
    private final UserAnswerDtoEntityMapper mapper;

    @Override
    public UserAnswerResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
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
        UserAnswer result = repository.save(userAnswer);
        return mapper.toDTO(result);
    }

    @Override
    public UserAnswerResponseDTO update(Long id, UserAnswerUpdateDTO updateDTO) {
//        UserAnswer userAnswer = mapper.toEntity(updateDTO);
//        UserAnswer result = repository.save(userAnswer);
//        return mapper.toDTO(result);
        return null;        // exception
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
