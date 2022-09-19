package b101.percast.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AdminServiceImplTest {

    @Autowired
    AdminService adminService;

    @Test
    void checkByRand() {
        String requestP = "암호화된 키값";
        adminService.checkByEncryptedP(requestP);

        Assertions.assertThat();


    }
}