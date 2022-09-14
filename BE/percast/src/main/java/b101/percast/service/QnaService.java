package b101.percast.service;

import b101.percast.dto.QnaDto;
import b101.percast.entity.Qna;

import java.util.List;

public interface QnaService {
    public List<Qna> findAll();
    public Qna findById(Long id);
    public Long create(QnaDto dto);
    public Long update(QnaDto dto);
    public void delete(Long id);
}
