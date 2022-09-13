package b101.percast.service;

import b101.percast.dto.QnaDto;
import b101.percast.entity.Qna;
import b101.percast.repository.QnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QnaServiceImpl implements QnaService{

    @Autowired
    private QnaRepository qnaRepository;
    @Override
    public List<Qna> findAll() {
        return qnaRepository.findAll();
    }

    @Override
    public Qna findById(Long id) {
        Optional<Qna> qnaOptional = qnaRepository.findById(id);
        if(qnaOptional.isPresent()) {
            return qnaOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Long create(QnaDto dto) {
        return qnaRepository.save(dto.toEntity()).getId();
    }

    @Override
    public Long update(QnaDto dto) {
        return qnaRepository.save(dto.toEntity()).getId();
    }

    @Override
    public void delete(Long id) {
        qnaRepository.deleteById(id);
    }
}
