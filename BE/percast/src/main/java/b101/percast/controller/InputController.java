package b101.percast.controller;

import b101.percast.dto.input.InputFindResponse;
import b101.percast.service.InputService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/input")
@RequiredArgsConstructor
public class InputController {
    private final InputService inputService;

    @GetMapping("/env")
    @ApiOperation(value = "현재 대기, 날씨정보 조회", notes = "현재 대기정보와 날씨정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(code = 200,message = "조회 성공"),
            @ApiResponse(code = 400, message = "데이터를 찾을 수 없음. 또는 잘못된 요청"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public InputFindResponse findInput(@RequestParam Long sidoCode) {
        return inputService.findInputBySidoCode(sidoCode);
    }
}
