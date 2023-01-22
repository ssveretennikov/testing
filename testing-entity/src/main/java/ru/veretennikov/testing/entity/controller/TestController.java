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
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestCreateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Request.TestUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.TestDTO.Response.TestResponseDTO;
import ru.veretennikov.testing.entity.service.TestService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class TestController {

    private final TestService testService;

    @GetMapping(value = "answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestResponseDTO> getTest(@PathVariable Long id) {
        return ResponseEntity.ok(testService.findById(id));
    }

    @GetMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TestResponseDTO>> getTests() {
        return ResponseEntity.ok(testService.findAll());
    }

    @PostMapping(value = "test}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestResponseDTO> createTest(@RequestBody TestCreateDTO createDTO) {
        return ResponseEntity.ok(testService.create(createDTO));
    }

    @PostMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestResponseDTO> updateTest(@RequestBody TestUpdateDTO updateDTO) {
        return ResponseEntity.ok(testService.update(updateDTO));
    }

    @DeleteMapping(value = "test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteTest(@PathVariable Long id) {
        testService.delete(id);
        return ResponseEntity.ok(String.format("Запись с id %d успешно удалена", id));
    }

}
