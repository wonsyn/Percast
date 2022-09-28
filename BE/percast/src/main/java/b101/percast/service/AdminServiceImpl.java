package b101.percast.service;

import b101.percast.dto.admin.AdminSaveDto;
import b101.percast.entity.Admin;
import b101.percast.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public void update(String password, String encryptedPassword) {
        Optional<Admin> OptionalAdmin = adminRepository.findByPassword(password);
        if (OptionalAdmin.isPresent()) {
            Admin admin = OptionalAdmin.get();
            AdminSaveDto dto = AdminSaveDto.builder().id(admin.getId())
                    .password(admin.getPassword()).encryptedPassword(encryptedPassword).build();
            adminRepository.save(dto.toEntity());
        }
    }

    @Override
    public boolean checkByEncryptedP(String encryptedPassword) {
        return adminRepository.findByEncryptedPassword(encryptedPassword).isPresent();
    }

    @Override
    public boolean checkByPass(String password) {
        Optional<Admin> optionalAdmin = adminRepository.findByPassword(password);
        return optionalAdmin.isPresent();
    }
}
