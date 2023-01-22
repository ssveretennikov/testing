package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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


    @Override
    public AnswerResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<AnswerResponseDTO> findAll() {
        return null;
    }

    @Override
    public AnswerResponseDTO create(AnswerCreateDTO createDTO) {
        return null;
    }

    @Override
    public AnswerResponseDTO update(AnswerUpdateDTO updateDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
