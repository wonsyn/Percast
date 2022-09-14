package b101.percast.dto.Qna;

import b101.percast.entity.Answer;
import b101.percast.entity.Qna;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class QnaUpdateDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Long id;
        private String title;
        private String content;
        private String tel;

        public Qna toEntity(String password, String date, Answer answer) {
            return Qna.builder()
                    .id(id).title(title).password(password).date(date)
                    .content(content).tel(tel).answer(answer).build();
        }
    }
}
