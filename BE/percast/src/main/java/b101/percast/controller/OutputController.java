package b101.percast.controller;

import b101.percast.dto.output.OutputFindAllResponseDto;
import b101.percast.service.OutputService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputController {

    private final OutputService outputService;

    @GetMapping
    public List<OutputFindAllResponseDto> readAll(){
        return outputService.findAll();
    }

}
