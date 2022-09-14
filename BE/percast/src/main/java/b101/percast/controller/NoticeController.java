package b101.percast.controller;

import b101.percast.dto.notice.NoticeFindAllDto;
import b101.percast.dto.notice.NoticeFindDto;
import b101.percast.dto.notice.NoticeSaveDto;
import b101.percast.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    // 공지사항 목록 조회
    @GetMapping
    public ResponseEntity<List<NoticeFindAllDto.Response>> getNotices() {
        return ResponseEntity.ok()
                .body(noticeService.getList());
    }

    // 공지 글 조회
    @GetMapping("/{id}")
    public ResponseEntity<NoticeFindDto.Response> getNotice(@PathVariable Long id) {
        return ResponseEntity.ok(noticeService.searchNoticeInfo(id));
    }

    // 공지 글 작성
//    @ApiOperation(value="회원 등록", notes="회원 정보를 입력받아 등록한다.")
    @PostMapping
    public ResponseEntity<Long> regist(@RequestBody NoticeSaveDto.Request dto) {
        return ResponseEntity.created(URI.create("/notice/" + noticeService.save(dto))).build();
    }

    // 공지 글 수정
    @PutMapping
    public ResponseEntity<Long> insert(@RequestBody NoticeSaveDto.Request dto) {
        noticeService.update(dto);
        return ResponseEntity.created(URI.create("/notice/" + dto.getId())).build();
    }

    // 공지 글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        noticeService.delete(id);
        return ResponseEntity.ok().build();
    }

}