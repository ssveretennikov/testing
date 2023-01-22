package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.UserAnswer;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Request.UserAnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Response.UserAnswerResponseDTO;
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
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<UserAnswerResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserAnswerResponseDTO create(UserAnswerCreateDTO createDTO) {
        UserAnswer answer = mapper.toEntity(createDTO);
        UserAnswer result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public UserAnswerResponseDTO update(UserAnswerUpdateDTO updateDTO) {
        UserAnswer answer = mapper.toEntity(updateDTO);
        UserAnswer result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
