package b101.percast.service;

import b101.percast.dto.Qna.*;

import java.util.List;

public interface QnaService {
    public List<QnaFindAllDto.Response> findAll();
    public QnaFindDto.Response findById(Long id);
    public Long create(QnaSaveDto.Request dto);
    public Long update(QnaUpdateDto.Request dto);
    public boolean delete(Long id);
    public boolean authPassword(QnaAuthDto.Request dto);
}
