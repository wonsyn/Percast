package b101.percast.service;

import b101.percast.dto.notice.NoticeFindAllResponseDto;
import b101.percast.dto.notice.NoticeFindResponseDto;
import b101.percast.dto.notice.NoticeSaveRequestDto;

import java.util.List;

public interface NoticeService {
    List<NoticeFindAllResponseDto> getList();
    void update(NoticeSaveRequestDto dto);
    void delete(Long id);
    Long save(NoticeSaveRequestDto dto);
    NoticeFindResponseDto findById(Long id);
}
