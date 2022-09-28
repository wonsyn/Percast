package b101.percast.service;


import b101.percast.Exception.noticeException.NoticeNotFoundException;
import b101.percast.dto.notice.NoticeFindAllResponseDto;
import b101.percast.dto.notice.NoticeFindResponseDto;
import b101.percast.dto.notice.NoticeSaveRequestDto;
import b101.percast.entity.Notice;
import b101.percast.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    @Override
    public List<NoticeFindAllResponseDto> getList() {
        return noticeRepository.findAll()
                .stream().map(NoticeFindAllResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void update(NoticeSaveRequestDto dto) {
        noticeRepository.save(dto.toEntity());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Long save(NoticeSaveRequestDto dto) {
        return noticeRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    @Override
    public NoticeFindResponseDto findById(Long id) {
        Optional<Notice> noticeOptional = noticeRepository.findById(id);
        if (noticeOptional.isEmpty()) {
            throw new NoticeNotFoundException();
        }
        return noticeOptional.map(NoticeFindResponseDto :: new).orElse(null);
    }
}
