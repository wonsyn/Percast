package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoticeDeleteByIdRequestDto {
    private Long id;

    /* DTO -> Entity */
    public Notice toEntity() {
        return Notice.builder()
                .id(id)
                .build();
    }

}
