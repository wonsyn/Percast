package b101.percast.service;

import b101.percast.dto.NoticeDto;
import b101.percast.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<NoticeDto.Response> getList();

    void update(NoticeDto.Request dto);

    void delete(Long id);

    Long save(NoticeDto.Request dto);

    NoticeDto.Response searchNoticeInfo(Long id);
}
