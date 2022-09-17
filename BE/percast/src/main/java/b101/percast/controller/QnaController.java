package b101.percast.controller;

import b101.percast.dto.Qna.*;
import b101.percast.dto.answer.*;
import b101.percast.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public QnaAuthResponse authPassword(@RequestBody QnaAuthRequest dto) {
        return new QnaAuthResponse(qnaService.authPassword(dto));
    }

    @PostMapping("/answer")
    public AnswerSaveResponse createAnswer(@RequestBody AnswerSaveRequest dto) {
        Long id = qnaService.createAnswer(dto);
        return new AnswerSaveResponse(id);
    }

    @PutMapping("/answer")
    public AnswerUpdateResponse updateAnswer(@RequestBody AnswerUpdateRequest dto) {
        Long id = qnaService.updateAnswer(dto);
        return new AnswerUpdateResponse(id);
    }

    @DeleteMapping("/answer")
    public AnswerDeleteResponse deleteAnswer(@RequestParam Long qnaid, @RequestParam Long answerid) {
        qnaService.deleteAnswer(qnaid, answerid);
        return new AnswerDeleteResponse(true);
    }
}
