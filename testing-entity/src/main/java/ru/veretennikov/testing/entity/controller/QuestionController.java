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
import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionUpdateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Response.QuestionResponseDTO;
import ru.veretennikov.testing.entity.service.QuestionService;

import java.util.List;

import static java.lang.String.format;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(value = "question/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid QuestionResponseDTO getQuestion(@PathVariable @NotNull @PositiveOrZero Long id) {
        return questionService.findById(id);
    }

    @GetMapping(value = "question", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid List<QuestionResponseDTO> getQuestions() {
        return questionService.findAll();
    }

    @PostMapping(value = "question", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid QuestionResponseDTO createQuestion(@RequestBody @Valid QuestionCreateDTO createDTO) {
        return questionService.create(createDTO);
    }

    @PutMapping(value = "question/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid QuestionResponseDTO updateQuestion(@RequestBody @Valid QuestionUpdateDTO updateDTO,
                                                     @PathVariable @NotNull @PositiveOrZero Long id) {
        return questionService.update(id, updateDTO);
    }

    @DeleteMapping(value = "question/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteQuestion(@PathVariable @NotNull @PositiveOrZero Long id) {
        questionService.delete(id);
        return format("Запись с id %d успешно удалена", id);
    }

}
