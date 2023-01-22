package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Request.QuestionUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Response.QuestionResponseDTO;
import ru.veretennikov.testing.entity.repository.QuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    @Override
    public QuestionResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<QuestionResponseDTO> findAll() {
        return null;
    }

    @Override
    public QuestionResponseDTO create(QuestionCreateDTO createDTO) {
        return null;
    }

    @Override
    public QuestionResponseDTO update(QuestionUpdateDTO updateDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
