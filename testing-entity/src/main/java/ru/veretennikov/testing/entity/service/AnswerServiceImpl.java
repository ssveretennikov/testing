package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.db.Answer;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Request.AnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Response.AnswerResponseDTO;
import ru.veretennikov.testing.entity.mapper.AnswerDtoEntityMapper;
import ru.veretennikov.testing.entity.repository.AnswerRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;
    private final AnswerDtoEntityMapper mapper;

    @Override
    public AnswerResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<AnswerResponseDTO> findAll() {
        return Stream.ofNullable(repository.findAll())
                .flatMap(Collection::stream)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerResponseDTO create(AnswerCreateDTO createDTO) {
        Answer answer = mapper.toEntity(createDTO);
        Answer result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public AnswerResponseDTO update(AnswerUpdateDTO updateDTO) {
        Answer answer = mapper.toEntity(updateDTO);
        Answer result = repository.save(answer);
        return mapper.toDto(result);
    }

    @Override
    public void delete(Long id) {
//        если не найдется запись по такому id, то бросается EmptyResultDataAccessException - отлавливать его в handler-е и возвращать ошибку с соответствующим кодом
        repository.deleteById(id);
    }

}
