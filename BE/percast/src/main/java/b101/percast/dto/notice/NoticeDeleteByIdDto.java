package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class NoticeDeleteByIdDto {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class Request {
        private Long id;

        /* DTO -> Entity */
        public Notice toEntity() {
            return Notice.builder()
                    .id(id)
                    .date(LocalDateTime.now())
                    .build();
        }
    }
}
