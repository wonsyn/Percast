package b101.percast.controller;

import b101.percast.dto.input.InputFindResponse;
import b101.percast.dto.input.InputSaveResponse;
import b101.percast.service.InputService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/input")
@RequiredArgsConstructor
public class InputController {
    private final InputService inputService;

    @GetMapping
    public InputSaveResponse saveInput() throws IOException {
        inputService.saveInputData();
        return InputSaveResponse.builder().success(true).build();
    }

    @GetMapping("/env")
    public InputFindResponse findInput(@RequestParam Long sidoCode) {
        return inputService.findInputBySidoCode(sidoCode);
    }
}
