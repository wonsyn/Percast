package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class NoticeFindDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private String date;
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
