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
import ru.veretennikov.testing.entity.dto.TestDTO.Request.TestCreateDTO;
import ru.veretennikov.testing.entity.dto.TestDTO.Request.TestUpdateDTO;
import ru.veretennikov.testing.entity.dto.TestDTO.Response.TestResponseDTO;
import ru.veretennikov.testing.entity.service.TestService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class TestController {

    private final TestService testService;

    @GetMapping(value = "test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid TestResponseDTO getTest(@PathVariable @NotNull @PositiveOrZero Long id) {
        return testService.findById(id);
    }

    @GetMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid List<TestResponseDTO> getTests() {
        return testService.findAll();
    }

    @PostMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid TestResponseDTO createTest(@RequestBody @Valid TestCreateDTO createDTO) {
        return testService.create(createDTO);
    }

    @PutMapping(value = "test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid TestResponseDTO updateTest(@RequestBody @Valid TestUpdateDTO updateDTO,
                                             @PathVariable @NotNull @PositiveOrZero Long id) {
        return testService.update(id, updateDTO);
    }

    @DeleteMapping(value = "test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTest(@PathVariable @NotNull @PositiveOrZero Long id) {
        testService.delete(id);
        return String.format("Запись с id %d успешно удалена", id);
    }

}
