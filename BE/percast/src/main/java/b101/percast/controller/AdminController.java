package b101.percast.controller;

import b101.percast.config.PasswordEncrypt;
import b101.percast.dto.admin.AdminSaveDto;
import b101.percast.service.AdminService;
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
    public ResponseEntity<Map<String, Object>> regist(@RequestBody AdminSaveDto dto){
        Map<String, Object> map = new HashMap<>();
        // 비밀번호 체크
        if(!adminService.checkByPass(dto.getPassword())){
            map.put("message","fail");
            return ResponseEntity.status(401).body(map);
        }
        map.put("message","success");
        String encryptedPassword = PasswordEncrypt.encrypt(dto.getPassword());
        System.out.println(encryptedPassword);
        adminService.update(dto.getPassword(), encryptedPassword);
        map.put("auth", encryptedPassword);
        return ResponseEntity.ok().body(map);
    }
    // 어드민관련 기능에 접근할 때 RequestBody에 난수 읽어서 어드민인지 확인은 필요한 곳에서 adminService호출하기

}
