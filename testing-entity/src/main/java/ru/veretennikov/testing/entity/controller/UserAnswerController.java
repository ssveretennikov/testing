package ru.veretennikov.testing.entity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserAnswerResponseDTO> getUserAnswer(@PathVariable Long id) {
        return ResponseEntity.ok(userAnswerService.findById(id));
    }

    @GetMapping(value = "user-answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserAnswerResponseDTO>> getUserAnswers() {
        return ResponseEntity.ok(userAnswerService.findAll());
    }

    @PostMapping(value = "user-answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAnswerResponseDTO> createUserAnswer(@RequestBody UserAnswerCreateDTO createDTO) {
        return ResponseEntity.ok(userAnswerService.create(createDTO));
    }

    @PutMapping(value = "user-answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAnswerResponseDTO> updateUserAnswer(@PathVariable Long id,
                                                                  @RequestBody UserAnswerUpdateDTO updateDTO) {
        return ResponseEntity.ok(userAnswerService.update(id, updateDTO));
    }

    @DeleteMapping(value = "user-answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUserAnswer(@PathVariable Long id) {
        userAnswerService.delete(id);
        return ResponseEntity.ok(String.format("Запись с id %d успешно удалена", id));
    }

}
