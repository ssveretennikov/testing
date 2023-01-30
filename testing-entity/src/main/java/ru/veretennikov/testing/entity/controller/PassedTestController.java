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
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestCreateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Request.PassedTestUpdateDTO;
import ru.veretennikov.testing.entity.dto.PassedTestDTO.Response.PassedTestResponseDTO;
import ru.veretennikov.testing.entity.service.PassedTestService;

import java.util.List;

import static java.lang.String.format;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class PassedTestController {

    private final PassedTestService passedTestService;

    @GetMapping(value = "passed-test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid PassedTestResponseDTO getPassedTest(@PathVariable @NotNull @PositiveOrZero Long id) {
        return passedTestService.findById(id);
    }

    @GetMapping(value = "passed-test", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid List<PassedTestResponseDTO> getPassedTests() {
        return passedTestService.findAll();
    }

    @PostMapping(value = "passed-test", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid PassedTestResponseDTO createPassedTest(@RequestBody @Valid PassedTestCreateDTO createDTO) {
        return passedTestService.create(createDTO);
    }

    @PutMapping(value = "passed-test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @Valid PassedTestResponseDTO updatePassedTest(@RequestBody @Valid PassedTestUpdateDTO updateDTO,
                                                         @PathVariable @NotNull @PositiveOrZero Long id) {
        return passedTestService.update(id, updateDTO);
    }

    @DeleteMapping(value = "passed-test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deletePassedTest(@PathVariable @NotNull @PositiveOrZero Long id) {
        passedTestService.delete(id);
        return format("Запись с id %d успешно удалена", id);
    }

}
