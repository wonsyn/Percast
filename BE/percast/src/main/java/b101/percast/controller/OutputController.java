package b101.percast.controller;

import b101.percast.api.ApiExplorer;
import b101.percast.dto.output.OutputFindAllResponseDto;
import b101.percast.service.OutputService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputController {

    private final OutputService outputService;

    @GetMapping
    @ApiOperation(value = "예측 위험지수 조회")
    public List<OutputFindAllResponseDto> readAll() throws IOException {
        List<String> foodPoisonList = ApiExplorer.getFoodPoison();
        outputService.save(foodPoisonList);
        return outputService.findAll();
    }

}
