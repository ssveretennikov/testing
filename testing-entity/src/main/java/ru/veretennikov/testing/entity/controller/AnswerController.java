package ru.veretennikov.testing.entity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Request.AnswerUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.AnswerDTO.Response.AnswerResponseDTO;
import ru.veretennikov.testing.entity.service.AnswerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping(value = "answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnswerResponseDTO> getAnswer(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.findById(id));
    }

    @GetMapping(value = "answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnswerResponseDTO>> getAnswers() {
        return ResponseEntity.ok(answerService.findAll());
    }

    @PostMapping(value = "answer}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnswerResponseDTO> createAnswer(@RequestBody AnswerCreateDTO createDTO) {
        return ResponseEntity.ok(answerService.create(createDTO));
    }

    @PostMapping(value = "answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnswerResponseDTO> updateAnswer(@RequestBody AnswerUpdateDTO updateDTO) {
        return ResponseEntity.ok(answerService.update(updateDTO));
    }

    @DeleteMapping(value = "answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAnswer(@PathVariable Long id) {
        answerService.delete(id);
        return ResponseEntity.ok(String.format("Запись с id %d успешно удалена", id));
    }

}
