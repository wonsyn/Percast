package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NoticeSaveDto {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class Request {
        private Long id;
        private String date;
        private String title;
        private String content;

        /* DTO -> Entity */
        public Notice toEntity() {
            return Notice.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();
        }
    }
}
