package b101.percast.controller;

import b101.percast.dto.message.MessageServiceFindAllByTelResponseDto;
import b101.percast.dto.message.MessageServiceSaveRequestDto;
import b101.percast.service.MessageServiceService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Api(tags = {"메시지 알림 설정 API"})
public class SendMessageController {

    private final MessageServiceService messageServiceService;

    @PostMapping
    @ApiOperation(value = "알림 서비스 생성", notes = "입력받은 사용자의 전화번호로 등록된 알림 서비스를 조회한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseEntity<?> writeMessage(@RequestBody @ApiParam(value = "등록하려는 알림 서비스가 담긴 DTO", required = true) MessageServiceSaveRequestDto requestDto){
        messageServiceService.save(requestDto);
        return ResponseEntity.created(URI.create("/")).build();
    }

    @GetMapping("{tel}")
    @ApiOperation(value = "알림 서비스 조회", notes = "입력받은 사용자의 전화번호로 등록된 알림 서비스를 조회한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseEntity<List<MessageServiceFindAllByTelResponseDto>> findAllByTel(@PathVariable @ApiParam(value = "사용자의 전화번호 (01012341234)", required = true) String tel){
        return ResponseEntity.ok().body(messageServiceService.findAllByTel(tel));
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "알림 서비스 삭제", notes = "전달받은 ID에 해당하는 알림 서비스를 삭제한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseEntity<Long> deleteMessage(@PathVariable @ApiParam(value = "삭제하려는 알림 서비스 ID", required = true) Long id){
        messageServiceService.delete(id);
        return ResponseEntity.ok().build();
    }


}
