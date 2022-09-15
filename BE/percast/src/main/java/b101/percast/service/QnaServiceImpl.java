package b101.percast.service;

import b101.percast.dto.Qna.*;
import b101.percast.entity.Qna;
import b101.percast.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService{

    private final QnaRepository qnaRepository;

    @Transactional
    @Override
    public List<QnaFindAllDto.Response> findAll() {
        return qnaRepository.findAll().stream().map(QnaFindAllDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public QnaFindDto.Response findById(Long id) {
        Optional<Qna> qnaOptional = qnaRepository.findById(id);
        if(qnaOptional.isPresent()) {
            return new QnaFindDto.Response(qnaOptional.get());
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public Long create(QnaSaveDto.Request dto) {
        return qnaRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    @Override
    public Long update(QnaUpdateDto.Request dto) {
        Optional<Qna> qnaOptional = qnaRepository.findById(dto.getId());
        if(qnaOptional.isPresent()) {
            Qna qna = qnaOptional.get();
            return qnaRepository.save(dto.toEntity(qna.getPassword(), qna.getDate(), qna.getAnswer())).getId();
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        qnaRepository.deleteById(id);
        QnaFindDto.Response qna = this.findById(id);
        return qna == null;
    }

    @Transactional
    @Override
    public boolean authPassword(QnaAuthDto.Request dto) {
        Optional<Qna> qnaOptional = qnaRepository.findById(dto.getId());
        if (qnaOptional.isPresent()) {
            return qnaOptional.get().getPassword().equals(dto.getPassword());
        }
        return false;
    }
}
