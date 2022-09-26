package b101.percast.controller;

import b101.percast.dto.output.OutputFindAllResponseDto;
import b101.percast.service.OutputService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/output")
@RequiredArgsConstructor
@Api(tags = {"위험지수 알림 API"})
public class OutputController {

    private final OutputService outputService;

    @GetMapping
    @ApiOperation(value = "예측 위험지수 조회", notes = "<strong><big>전체 지역별 질병 위험지수</big></strong>를 조회한다.")
    @ApiResponses({
            @ApiResponse(code=200,message="요청 성공"),
            @ApiResponse(code=400,message="데이터를 찾을 수 없음. 또는 잘못된 요청"),
            @ApiResponse(code=500,message="서버 에러")
    })
    public List<OutputFindAllResponseDto> readAll(){
        return outputService.findAll();
    }

}
