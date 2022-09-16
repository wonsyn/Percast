package b101.percast.dto.Qna;

import b101.percast.entity.Answer;
import b101.percast.entity.Qna;
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
public class QnaFindResponse {
    private Long id;
    private String title;
    private String content;
    private String tel;
    private Answer answer;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime date;

    public QnaFindResponse(Qna qna) {
        this.id = qna.getId();
        this.title = qna.getTitle();
        this.content = qna.getContent();
        this.tel = qna.getTel();
        this.answer = qna.getAnswer();
        this.date = qna.getDate();
    }
}
