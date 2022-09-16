package b101.percast.controller;

import b101.percast.dto.Qna.*;
import b101.percast.dto.answer.AnswerSaveDto;
import b101.percast.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
public class QnaController {
    private final QnaService qnaService;

    @PostMapping
    public QnaSaveResponse create(@RequestBody QnaSaveRequest request) {
        Long id = qnaService.create(request);
        return new QnaSaveResponse(id);
    }

    @GetMapping
    public List<QnaFindAllResponse> readAll() {
        List<QnaFindAllResponse> list = qnaService.findAll();
        return list;
    }

    @GetMapping("/detail")
    public QnaFindResponse read(@RequestParam Long qnaId) {
        return qnaService.findById(qnaId);
    }

    @PutMapping
    public QnaUpdateResponse update(@RequestBody QnaUpdateRequest dto) {
        Long id = qnaService.update(dto);
        return new QnaUpdateResponse(id);
    }

    @DeleteMapping("{id}")
    public QnaDeleteResponse delete(@PathVariable Long id) {
        qnaService.delete(id);
        return new QnaDeleteResponse(true);
    }

    @PostMapping("/password")
    public ResponseEntity<Map<String, Object>> authPassword(@RequestBody QnaAuthDto.Request dto) {
        Map<String, Object> map = new HashMap<>();
        String msg = "success";
        HttpStatus status = HttpStatus.OK;
        if(!qnaService.authPassword(dto)) {
            msg = "fail";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
    }

    @PostMapping("/answer")
    public ResponseEntity<Map<String, Object>> createAnswer(@RequestBody AnswerSaveDto.Request dto) {
        Map<String, Object> map = new HashMap<>();
        String msg = "success";
        HttpStatus status = HttpStatus.OK;
        Long id = qnaService.createAnswer(dto);
        if(id != null) {
            map.put("id", id);
        } else {
            msg = "fail";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
    }
}
