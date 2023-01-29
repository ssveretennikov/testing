package ru.veretennikov.testing.entity.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Response.AnswerResponseDTO;
import ru.veretennikov.testing.entity.service.AnswerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping(value = "answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid AnswerResponseDTO getAnswer(@PathVariable @NotNull @PositiveOrZero Long id) {
        return answerService.findById(id);
    }

    @GetMapping(value = "answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid List<AnswerResponseDTO> getAnswers() {
        return answerService.findAll();
    }

    @PostMapping(value = "answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid AnswerResponseDTO createAnswer(@RequestBody @Valid AnswerCreateDTO createDTO) {
        return answerService.create(createDTO);
    }

    @PutMapping(value = "answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid AnswerResponseDTO updateAnswer(@RequestBody @Valid AnswerUpdateDTO updateDTO,
                                                 @PathVariable @NotNull @PositiveOrZero Long id) {
        return answerService.update(id, updateDTO);
    }

    @DeleteMapping(value = "answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteAnswer(@PathVariable @NotNull @PositiveOrZero Long id) {
        answerService.delete(id);
        return String.format("Запись с id %d успешно удалена", id);
    }

}
