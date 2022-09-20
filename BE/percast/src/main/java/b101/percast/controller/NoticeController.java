package b101.percast.controller;

import b101.percast.dto.notice.NoticeFindAllResponseDto;
import b101.percast.dto.notice.NoticeFindResponseDto;
import b101.percast.dto.notice.NoticeSaveRequestDto;
import b101.percast.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
@Api(tags = {"공지사항 API"})
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    @ApiOperation(value = "목록조회", notes = "글목록을 조회한다.")
    public List<NoticeFindAllResponseDto> getNotices() {
        return noticeService.getList();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "공지글 조회", notes = "공지글번호를 입력받아 글을 조회한다.")
    public NoticeFindResponseDto getNotice(@PathVariable Long id) {
        return noticeService.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "공지글 등록", notes = "제목과 내용을 입력받아 글을 등록한다.")
    public ResponseEntity<Long> regist(@RequestBody NoticeSaveRequestDto dto) {
        return ResponseEntity.created(URI.create("/notice/" + noticeService.save(dto))).build();
    }

    @PutMapping
    @ApiOperation(value = "공지글 수정", notes = "글번호, 제목, 내용을 입력받아 글을 수정한다.")
    public ResponseEntity<Long> insert(@RequestBody NoticeSaveRequestDto dto) {
        noticeService.update(dto);
        return ResponseEntity.created(URI.create("/notice/" + dto.getId())).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "공지글 삭제", notes = "글번호를 입력받아 글을 삭제한다.")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        noticeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
