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
import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Request.QuestionUpdateDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO.Response.QuestionResponseDTO;
import ru.veretennikov.testing.entity.service.QuestionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(value = "question/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionResponseDTO getQuestion(@PathVariable Long id) {
        return questionService.findById(id);
    }

    @GetMapping(value = "question", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionResponseDTO> getQuestions() {
        return questionService.findAll();
    }

    @PostMapping(value = "question", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionResponseDTO createQuestion(@Valid @RequestBody QuestionCreateDTO createDTO) {
        return questionService.create(createDTO);
    }

    @PutMapping(value = "question/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionResponseDTO updateQuestion(@Valid @RequestBody QuestionUpdateDTO updateDTO, @PathVariable Long id) {
        return questionService.update(id, updateDTO);
    }

    @DeleteMapping(value = "question/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteQuestion(@PathVariable Long id) {
        questionService.delete(id);
        return String.format("Запись с id %d успешно удалена", id);
    }

}
