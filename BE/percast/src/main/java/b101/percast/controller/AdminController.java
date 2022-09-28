package b101.percast.controller;

import b101.percast.config.PasswordEncrypt;
import b101.percast.dto.admin.AdminSaveDto;
import b101.percast.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Api(tags = {"어드민 관련 API"})
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    @ApiOperation(value = "어드민계정 등록", notes = "요청의 패스워드 확인해서 암호화된 패스워드를 db업데이트 후 반환한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "등록 성공"),
            @ApiResponse(code = 400, message = "데이터를 찾을 수 없음. 또는 잘못된 요청"),
            @ApiResponse(code = 401, message = "비밀번호가 틀려서 접근할 수 없습니다."),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseEntity<Map<String, Object>> regist(@RequestBody AdminSaveDto dto) {
        Map<String, Object> map = new HashMap<>();
        if (!adminService.checkByPass(dto.getPassword())) {
            map.put("message", "fail");
            return ResponseEntity.status(401).body(map);
        }
        map.put("message", "success");
        String encryptedPassword = PasswordEncrypt.encrypt(dto.getPassword());
        adminService.update(dto.getPassword(), encryptedPassword);
        map.put("auth", encryptedPassword);
        return ResponseEntity.ok().body(map);
    }
}
