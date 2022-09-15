package b101.percast.dto.Qna;

import b101.percast.entity.Answer;
import b101.percast.entity.Qna;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class QnaSaveDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private String title;
        private String content;
        private String password;
        private String tel;
        private Answer answer;

        public Qna toEntity() {
            return Qna.builder()
                    .title(title).content(content)
                    .password(password).tel(tel).answer(answer).build();
        }
    }
}
