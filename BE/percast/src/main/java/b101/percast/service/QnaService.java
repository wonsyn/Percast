package b101.percast.service;

import b101.percast.dto.Qna.*;
import b101.percast.dto.answer.AnswerSaveRequest;
import b101.percast.dto.answer.AnswerUpdateRequest;

import java.util.List;

public interface QnaService {
    List<QnaFindAllResponse> findAll();
    QnaFindResponse findById(Long id);
    Long create(QnaSaveRequest dto);
    Long update(QnaUpdateRequest dto);
    void delete(Long id);
    boolean authPassword(QnaAuthRequest dto);
    Long createAnswer(AnswerSaveRequest dto);
    Long updateAnswer(AnswerUpdateRequest dto);
    void deleteAnswer(Long qnaId, Long answerId);
}
