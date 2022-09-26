package b101.percast.repository;

import b101.percast.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByPassword(String password);
    Optional<Admin> findByEncryptedPassword(String password);
}