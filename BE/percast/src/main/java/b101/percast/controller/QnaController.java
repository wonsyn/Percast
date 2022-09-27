package b101.percast.controller;

import b101.percast.Exception.AdminUnauthorizationException;
import b101.percast.dto.Qna.*;
import b101.percast.dto.answer.*;
import b101.percast.service.AdminService;
import b101.percast.service.QnaService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
@Api(tags = {"QnA API"})
public class QnaController {
    private final QnaService qnaService;
    private final AdminService adminService;

    @PostMapping
    @ApiOperation(value = "QnA 작성", notes = "QnA를 작성하는 요청")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public QnaSaveResponse create(@RequestBody @ApiParam(value = "작성할 QnA의 정보가 담긴 객체", required = true) QnaSaveRequest request) {
        Long id = qnaService.create(request);
        return new QnaSaveResponse(id);
    }

    @GetMapping
    @ApiOperation(value = "QnA 전체조회", notes = "모든 QnA 리스트를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public List<QnaFindAllResponse> readAll() {
        List<QnaFindAllResponse> list = qnaService.findAll();
        return list;
    }

    @ApiOperation(value = "QnA 상세조회", notes = "QnA 의 정보를 상세조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/detail")
    public QnaFindResponse read(@RequestParam @ApiParam(value = "QnA ID", required = true) Long qnaId) {
        return qnaService.findById(qnaId);
    }

    @ApiOperation(value = "QnA 수정", notes = "QnA 를 수정하는 요청")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PutMapping
    public QnaUpdateResponse update(@RequestBody @ApiParam(value = "수정할 정보를 담고있는 QnA 객체", required = true) QnaUpdateRequest dto) {
        Long id = qnaService.update(dto);
        return new QnaUpdateResponse(id);
    }

    @ApiOperation(value = "QnA 삭제", notes = "QnA 를 삭제하는 요청")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @DeleteMapping("{id}")
    public QnaDeleteResponse delete(@PathVariable @ApiParam(value = "삭제할 QnA의 ID", required = true) Long id) {
        qnaService.delete(id);
        return new QnaDeleteResponse(true);
    }

    @ApiOperation(value = "QnA 비밀번호 인증", notes = "QnA 수정, 삭제를 위한 비밀번호를 인증하는 요청")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/password")
    public QnaAuthResponse authPassword(@RequestBody @ApiParam(value = "QnA의 ID와 비밀번호를 담고 있는 객체", required = true) QnaAuthRequest dto) {
        return new QnaAuthResponse(qnaService.authPassword(dto));
    }

    @ApiOperation(value = "Answer 작성", notes = "Answer를 작성하는 요청")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 401, message = "Admin 인증 실패"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/answer")
    public AnswerSaveResponse createAnswer(@RequestHeader("Authorization") @ApiParam(value = "Admin 로그인 인증 코드") String code, @RequestBody @ApiParam(value = "작성할 Answer의 내용을 담고 있는 객체", required = true) AnswerSaveRequest dto) {
        if(!adminService.checkByEncryptedP(code)) throw new AdminUnauthorizationException();
        Long id = qnaService.createAnswer(dto);
        return new AnswerSaveResponse(id);
    }

    @ApiOperation(value = "Answer 수정", notes = "Answer를 수정하는 요청")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 400, message = "잘못된 요청 또는 해당 Answer 없음"),
            @ApiResponse(code = 401, message = "Admin 인증 실패"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PutMapping("/answer")
    public AnswerUpdateResponse updateAnswer(@RequestHeader("Authorization") @ApiParam(value = "Admin 로그인 인증 코드") String code, @RequestBody @ApiParam(value = "수정할 Answer의 내용을 담고 있는 객체", required = true) AnswerUpdateRequest dto) {
        if(!adminService.checkByEncryptedP(code)) throw new AdminUnauthorizationException();
        Long id = qnaService.updateAnswer(dto);
        return new AnswerUpdateResponse(id);
    }

    @ApiOperation(value = "Answer 삭제", notes = "Answer를 삭제하는 요청")
    @ApiResponses({
            @ApiResponse(code = 200, message = "요청 성공"),
            @ApiResponse(code = 204, message = "해당 QnA객체 없음"),
            @ApiResponse(code = 401, message = "Admin 인증 실패"),
            @ApiResponse(code = 500, message = "서버 에러"),
    })
    @DeleteMapping("/answer")
    public AnswerDeleteResponse deleteAnswer(@RequestHeader("Authorization") @ApiParam(value = "Admin 로그인 인증 코드") String code, @RequestParam @ApiParam(value = "답변을 삭제할 Answer가 붙어있는 QnA ID", required = true) Long qnaid, @RequestParam @ApiParam(value = "삭제할 Answer의 ID") Long answerid) {
        if(!adminService.checkByEncryptedP(code)) throw new AdminUnauthorizationException();
        qnaService.deleteAnswer(qnaid, answerid);
        return new AnswerDeleteResponse(true);
    }
}
