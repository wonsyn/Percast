package b101.percast.controller;

import b101.percast.Exception.AdminUnauthorizationException;
import b101.percast.dto.notice.NoticeFindAllResponseDto;
import b101.percast.dto.notice.NoticeFindResponseDto;
import b101.percast.dto.notice.NoticeSaveRequestDto;
import b101.percast.service.AdminService;
import b101.percast.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
@Api(tags = {"공지사항 관련 API"})
public class NoticeController {
    private final NoticeService noticeService;
    private final AdminService adminService;

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
    public ResponseEntity<Long> regist(@RequestHeader("Authorization") @ApiParam(value = "Admin 로그인 인증 코드") String code, @RequestBody NoticeSaveRequestDto dto) {
        if(!adminService.checkByEncryptedP(code)) throw new AdminUnauthorizationException();
        return ResponseEntity.created(URI.create("/notice/" + noticeService.save(dto))).build();
    }

    @PutMapping
    @ApiOperation(value = "공지글 수정", notes = "글번호, 제목, 내용을 입력받아 글을 수정한다.")
    public ResponseEntity<Long> insert(@RequestHeader("Authorization") @ApiParam(value = "Admin 로그인 인증 코드") String code, @RequestBody NoticeSaveRequestDto dto) {
        if(!adminService.checkByEncryptedP(code)) throw new AdminUnauthorizationException();
        noticeService.update(dto);
        return ResponseEntity.created(URI.create("/notice/" + dto.getId())).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "공지글 삭제", notes = "글번호를 입력받아 글을 삭제한다.")
    public ResponseEntity<Long> delete(@RequestHeader("Authorization") @ApiParam(value = "Admin 로그인 인증 코드") String code, @PathVariable Long id) {
        if(!adminService.checkByEncryptedP(code)) throw new AdminUnauthorizationException();
        noticeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
