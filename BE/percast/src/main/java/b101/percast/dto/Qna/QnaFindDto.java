package b101.percast.dto.Qna;

import b101.percast.entity.Answer;
import b101.percast.entity.Qna;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class QnaFindDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private String title;
        private String content;
        private String tel;
        private Answer answer;

        public Response(Qna qna) {
            this.id = qna.getId(); this.title = qna.getTitle();
            this.content = qna.getContent(); this.tel = qna.getTel(); this.answer = qna.getAnswer();
        }
    }
}
