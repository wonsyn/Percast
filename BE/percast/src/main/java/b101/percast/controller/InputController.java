package b101.percast.controller;

import b101.percast.service.InputService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/input")
@RequiredArgsConstructor
public class InputController {
    private final InputService inputService;

    }
}
