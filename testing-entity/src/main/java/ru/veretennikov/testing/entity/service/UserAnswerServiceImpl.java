package ru.veretennikov.testing.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Request.UserAnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.UserAnswerDTO.Response.UserAnswerResponseDTO;
import ru.veretennikov.testing.entity.repository.UserAnswerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {

    private final UserAnswerRepository repository;

    @Override
    public UserAnswerResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<UserAnswerResponseDTO> findAll() {
        return null;
    }

    @Override
    public UserAnswerResponseDTO create(UserAnswerCreateDTO createDTO) {
        return null;
    }

    @Override
    public UserAnswerResponseDTO update(UserAnswerUpdateDTO updateDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
