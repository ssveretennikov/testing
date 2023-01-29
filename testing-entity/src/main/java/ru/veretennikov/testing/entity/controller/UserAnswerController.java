package ru.veretennikov.testing.entity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Response.UserAnswerResponseDTO;
import ru.veretennikov.testing.entity.service.UserAnswerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class UserAnswerController {

    private final UserAnswerService userAnswerService;

    @GetMapping(value = "user-answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserAnswerResponseDTO getUserAnswer(@PathVariable Long id) {
        return userAnswerService.findById(id);
    }

    @GetMapping(value = "user-answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserAnswerResponseDTO> getUserAnswers() {
        return userAnswerService.findAll();
    }

    @PostMapping(value = "user-answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserAnswerResponseDTO createUserAnswer(@Valid @RequestBody UserAnswerCreateDTO createDTO) {
        return userAnswerService.create(createDTO);
    }

    @PutMapping(value = "user-answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserAnswerResponseDTO updateUserAnswer(@Valid @RequestBody UserAnswerUpdateDTO updateDTO, @PathVariable Long id) {
        return userAnswerService.update(id, updateDTO);
    }

    @DeleteMapping(value = "user-answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUserAnswer(@PathVariable Long id) {
        userAnswerService.delete(id);
        return String.format("Запись с id %d успешно удалена", id);
    }

}
