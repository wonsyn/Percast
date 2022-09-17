package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeFindResponseDto {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime date;
    private String title;
    private String content;

    /* Entity -> DTO */
    public NoticeFindResponseDto(Notice entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

}
