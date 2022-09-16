package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoticeSaveRequestDto {
    private Long id;
    private String title;
    private String content;

    /* DTO -> Entity */
    public Notice toEntity() {
        return Notice.builder()
                .id(id)
                .title(title)
                .content(content)
                .date(LocalDateTime.now())
                .build();
    }

}
