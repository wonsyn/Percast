package b101.percast.controller;

import b101.percast.dto.twit.TwitFindAllResponseDto;
import b101.percast.service.TwitService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/twit")
@RequiredArgsConstructor
public class TwitController {

    private final TwitService twitService;

    @GetMapping
    @ApiOperation(value = "트윗 리스트 조회", notes = "wordCount된 단어들의 순위를 조회한다.")
    @ApiResponses({
            @ApiResponse(code=200,message="요청 성공"),
            @ApiResponse(code=400,message="데이터를 찾을 수 없음. 또는 잘못된 요청"),
            @ApiResponse(code=500,message="서버 에러")
    })
    public List<TwitFindAllResponseDto> getNotices(@RequestParam String disease) {
        return twitService.getTwits(disease);
    }
}
