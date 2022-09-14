package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class NoticeSaveDto {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class Request {
        private Long id;
        private LocalDateTime date;
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
}
