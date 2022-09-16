package b101.percast.service;

import b101.percast.Exception.QnaNotFoundException;
import b101.percast.dto.Qna.*;
import b101.percast.dto.answer.AnswerSaveDto;
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
    public boolean authPassword(QnaAuthDto.Request dto) {
        Optional<Qna> qnaOptional = qnaRepository.findById(dto.getId());
        return qnaOptional.map(qna -> qna.getPassword().equals(dto.getPassword())).orElse(false);
    }

    @Transactional
    @Override
    public Long createAnswer(AnswerSaveDto.Request dto) {
        Optional<Qna> qnaOptional = qnaRepository.findById(dto.getQnaId());
        if(qnaOptional.isPresent()) {
            Qna qna = qnaOptional.get();
//            Long answerId = answerRepository.save(Answer.builder().qna(qna).content(dto.getContent()).build()).getId());
//            Long answerId = answerRepository.save(Answer.builder().content(dto.getContent()).build()).getId();
            Answer answer = answerRepository.save(Answer.builder().content(dto.getContent()).build());
            qna.updateAnswer(answer);
            return answer.getId();

//            QnaUpdateDto.Request qnaDto = QnaUpdateDto.Request.builder().id(qna.getId()).title(qna.getTitle()).content(qna.getContent()).tel(qna.getTel()).build();
//            Optional<Answer> ansOptional = answerRepository.findById(answerId);
//            if(ansOptional.isPresent()) {
//                qnaRepository.save(qnaDto.toEntity(qna.getPassword(), null, ansOptional.get()));
//                return answerId;
//            } else {
//                return null;
//            }
        } else {
            return null;
        }

//        dto.toEntity()
//        QnaFindDto.Response = this.
//        if(qnaOptional.isPresent()) {
//            return answerRepository.save(dto.toEntity(qnaOptional.get())).getId();
//        }
//        return null;
    }
}
