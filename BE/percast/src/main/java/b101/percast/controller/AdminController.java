package b101.percast.controller;

import b101.percast.config.PasswordEncrypt;
import b101.percast.dto.admin.AdminSaveDto;
import b101.percast.service.AdminService;
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
public class AdminController {


    private final AdminService adminService;

    // 처음에 패스워드 입력받고 난수 생성해서 응답에 보내주는 API + DB에 난수, pass저장되야됨
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
        // 비밀번호 체크
        if (!adminService.checkByPass(dto.getPassword())) {
            map.put("message", "fail");
            return ResponseEntity.status(401).body(map);
        }
        map.put("message", "success");
        String encryptedPassword = PasswordEncrypt.encrypt(dto.getPassword());
        System.out.println(encryptedPassword);
        adminService.update(dto.getPassword(), encryptedPassword);
        map.put("auth", encryptedPassword);
        return ResponseEntity.ok().body(map);
    }
    // 어드민관련 기능에 접근할 때 RequestBody에 난수 읽어서 어드민인지 확인은 필요한 곳에서 adminService호출하기

}
