package ru.veretennikov.testing.entity.controller;

import jakarta.validation.Valid;
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
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestUpdateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Response.PassedTestResponseDTO;
import ru.veretennikov.testing.entity.service.PassedTestService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class PassedTestController {

    private final PassedTestService passedTestService;

    @GetMapping(value = "passed-test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassedTestResponseDTO> getPassedTest(@PathVariable Long id) {
        return ResponseEntity.ok(passedTestService.findById(id));
    }

    @GetMapping(value = "passed-test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PassedTestResponseDTO>> getPassedTests() {
        return ResponseEntity.ok(passedTestService.findAll());
    }

    @PostMapping(value = "passed-test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassedTestResponseDTO> createPassedTest(@Valid @RequestBody PassedTestCreateDTO createDTO) {
        return ResponseEntity.ok(passedTestService.create(createDTO));
    }

    @PutMapping(value = "passed-test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassedTestResponseDTO> updatePassedTest(@Valid @RequestBody PassedTestUpdateDTO updateDTO,
                                                                  @PathVariable Long id) {
        return ResponseEntity.ok(passedTestService.update(id, updateDTO));
    }

    @DeleteMapping(value = "passed-test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePassedTest(@PathVariable Long id) {
        passedTestService.delete(id);
        return ResponseEntity.ok(String.format("Запись с id %d успешно удалена", id));
    }

}
