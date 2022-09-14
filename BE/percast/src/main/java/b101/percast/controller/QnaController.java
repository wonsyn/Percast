package b101.percast.controller;

import b101.percast.dto.QnaDto;
import b101.percast.entity.Qna;
import b101.percast.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qna")
public class QnaController {
    @Autowired
    private QnaService qnaService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody QnaDto dto) {
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
        List<Qna> list = qnaService.findAll();
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
        Qna qna = qnaService.findById(qnaId);
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
    public ResponseEntity<Map<String, Object>> update(@RequestBody QnaDto dto) {
        Map<String, Object> map = new HashMap<>();
        String msg = "success";
        HttpStatus status = HttpStatus.OK;
        Qna qna = qnaService.findById(dto.getId());
        if(qna != null) {
            QnaDto tempDto = QnaDto.builder().id(dto.getId()).title(dto.getTitle()).content(dto.getContent())
                    .tel(qna.getTel()).date(qna.getDate()).answer(qna.getAnswer()).password(qna.getPassword()).build();
            map.put("id", qnaService.update(tempDto));
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
        Qna qna = qnaService.findById(id);
        if(qna != null) {
            qnaService.delete(qna.getId());
        } else {
            msg = "fail";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
    }
}
