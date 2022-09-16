package b101.percast.service;

import b101.percast.dto.Qna.*;
import b101.percast.dto.answer.AnswerSaveDto;

import java.util.List;

public interface QnaService {
    List<QnaFindAllResponse> findAll();
    QnaFindResponse findById(Long id);
    Long create(QnaSaveRequest dto);
    Long update(QnaUpdateRequest dto);
    void delete(Long id);
    boolean authPassword(QnaAuthDto.Request dto);
    Long createAnswer(AnswerSaveDto.Request dto);
}
