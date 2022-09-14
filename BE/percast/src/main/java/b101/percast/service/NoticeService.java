package b101.percast.service;

import b101.percast.dto.notice.NoticeFindAllDto;
import b101.percast.dto.notice.NoticeFindDto;
import b101.percast.dto.notice.NoticeSaveDto;

import java.util.List;

public interface NoticeService {
    List<NoticeFindAllDto.Response> getList();

    void update(NoticeSaveDto.Request dto);

    void delete(Long id);

    Long save(NoticeSaveDto.Request dto);

    NoticeFindDto.Response searchNoticeInfo(Long id);
}
