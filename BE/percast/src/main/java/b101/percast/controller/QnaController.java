package b101.percast.controller;

import b101.percast.dto.Qna.*;
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
    public ResponseEntity<Map<String, Object>> create(@RequestBody QnaSaveDto.Request dto) {
        Map<String, Object> map = new HashMap<>();
        String msg = "success";
        HttpStatus status = HttpStatus.OK;
        Long id = qnaService.create(dto);
        if(id == null) {
            msg = "fail";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            map.put("id", id);
        }
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> readAll() {
        Map<String, Object> map = new HashMap<>();
        String msg = "success";
        HttpStatus status = HttpStatus.OK;
        List<QnaFindAllDto.Response> list = qnaService.findAll();
        if(list == null) {
            msg = "fail";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            map.put("data", list);
        }
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
    }

    @GetMapping("/detail")
    public ResponseEntity<Map<String, Object>> read(@RequestParam Long qnaId) {
        Map<String, Object> map = new HashMap<>();
        String msg = "success";
        HttpStatus status = HttpStatus.OK;
        QnaFindDto.Response qna = qnaService.findById(qnaId);
        if(qna != null) {
            map.put("data", qna);
        } else {
            msg = "fail";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> update(@RequestBody QnaUpdateDto.Request dto) {
        Map<String, Object> map = new HashMap<>();
        String msg = "success";
        HttpStatus status = HttpStatus.OK;
        Long id = qnaService.update(dto);
        if(id != null) {
            map.put("id", id);
        } else {
            msg = "fail";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        String msg = "success";
        HttpStatus status = HttpStatus.OK;
        if(!qnaService.delete(id)) {
            msg = "fail";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
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
}
