package b101.percast.service;


import b101.percast.dto.NoticeDto;
import b101.percast.entity.Notice;
import b101.percast.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    @Override
    public List<NoticeDto.Response> getList() {
        return noticeRepository.findAll()
                .stream().map(NoticeDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void update(NoticeDto.Request dto) {
        noticeRepository.save(Notice.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .date(LocalDateTime.now())
                .build());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Long save(NoticeDto.Request dto) {
        return noticeRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    @Override
    public NoticeDto.Response searchNoticeInfo(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. 글번호: " + id));
        return new NoticeDto.Response(notice);
    }
}
