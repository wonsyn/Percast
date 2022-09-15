package b101.percast.dto.admin;

import b101.percast.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link b101.percast.entity.Admin} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminSaveDto implements Serializable {
    private Long id;
    private String password;
    private String encryptedPassword;


    public Admin toEntity() {
        return Admin.builder()
                .id(id)
                .password(password)
                .encryptedPassword(encryptedPassword)
                .build();
    }
}