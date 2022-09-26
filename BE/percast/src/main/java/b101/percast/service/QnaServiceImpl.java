package b101.percast.service;

import b101.percast.Exception.AnswerNotFoundException;
import b101.percast.Exception.NoParentQnaException;
import b101.percast.Exception.QnaNotFoundException;
import b101.percast.dto.Qna.*;
import b101.percast.dto.answer.AnswerSaveRequest;
import b101.percast.dto.answer.AnswerUpdateRequest;
import b101.percast.entity.Answer;
import b101.percast.entity.Qna;
import b101.percast.repository.AnswerRepository;
import b101.percast.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaRepository qnaRepository;
    private final AnswerRepository answerRepository;

    @Override
    public List<QnaFindAllResponse> findAll() {
        return qnaRepository.findAll().stream().map(QnaFindAllResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public QnaFindResponse findById(Long id) {
        Optional<Qna> qnaOptional = qnaRepository.findById(id);
        if(qnaOptional.isEmpty()) {
            throw new QnaNotFoundException();
        }
        return qnaOptional.map(QnaFindResponse::new).orElse(null);
    }

    @Transactional
    @Override
    public Long create(QnaSaveRequest dto) {
        return qnaRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    @Override
    public Long update(QnaUpdateRequest dto) {
        Qna qna = qnaRepository.findById(dto.getId()).orElseThrow(QnaNotFoundException::new);
        return qna.update(dto.getTitle(), dto.getContent()).getId();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        qnaRepository.deleteById(id);
    }

    @Override
    public boolean authPassword(QnaAuthRequest dto) {
        Optional<Qna> qnaOptional = qnaRepository.findById(dto.getId());
        return qnaOptional.map(qna -> qna.getPassword().equals(dto.getPassword())).orElse(false);
    }

    @Transactional
    @Override
    public Long createAnswer(AnswerSaveRequest dto) {
        Qna qna = qnaRepository.findById(dto.getQnaId()).orElseThrow(NoParentQnaException::new);
        Answer answer = answerRepository.save(dto.toEntity());
        qna.updateAnswer(answer);
        return answer.getId();
    }

    @Transactional
    @Override
    public Long updateAnswer(AnswerUpdateRequest dto) {
        Answer answer = answerRepository.findById(dto.getId()).orElseThrow(AnswerNotFoundException::new);
        return answer.update(dto.getContent()).getId();
    }

    @Transactional
    @Override
    public void deleteAnswer(Long qnaId, Long answerId) {
        Qna qna = qnaRepository.findById(qnaId).orElseThrow(QnaNotFoundException::new);
        qna.updateAnswer(null);
        answerRepository.deleteById(answerId);
    }
}
