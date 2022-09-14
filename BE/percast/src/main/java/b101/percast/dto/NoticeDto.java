package b101.percast.dto;

import b101.percast.entity.Notice;
import lombok.*;

import java.time.LocalDateTime;


public class NoticeDto {
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

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private LocalDateTime date;
        private String title;
        private String content;

        /* Entity -> DTO */
        public Response(Notice entity) {
            this.id = entity.getId();
            this.date = entity.getDate();
            this.title = entity.getTitle();
            this.content = entity.getContent();
        }
    }

}
