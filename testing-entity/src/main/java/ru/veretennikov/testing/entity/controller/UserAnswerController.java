package ru.veretennikov.testing.entity.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Request.UserAnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.UserAnswerDTO.Response.UserAnswerResponseDTO;
import ru.veretennikov.testing.entity.service.UserAnswerService;

import java.util.List;

import static java.lang.String.format;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class UserAnswerController {

    private final UserAnswerService userAnswerService;

    @GetMapping(value = "user-answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid UserAnswerResponseDTO getUserAnswer(@PathVariable @NotNull @PositiveOrZero Long id) {
        return userAnswerService.findById(id);
    }

    @GetMapping(value = "user-answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid List<UserAnswerResponseDTO> getUserAnswers() {
        return userAnswerService.findAll();
    }

    @PostMapping(value = "user-answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid UserAnswerResponseDTO createUserAnswer(@RequestBody @Valid UserAnswerCreateDTO createDTO) {
        return userAnswerService.create(createDTO);
    }

    @PutMapping(value = "user-answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid UserAnswerResponseDTO updateUserAnswer(@RequestBody @Valid UserAnswerUpdateDTO updateDTO,
                                                         @PathVariable @NotNull @PositiveOrZero Long id) {
        return userAnswerService.update(id, updateDTO);
    }

    @DeleteMapping(value = "user-answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUserAnswer(@NotNull @PositiveOrZero @PathVariable Long id) {
        userAnswerService.delete(id);
        return format("Запись с id %d успешно удалена", id);
    }

}
