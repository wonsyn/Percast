package b101.percast.dto.Qna;

import b101.percast.entity.Answer;
import b101.percast.entity.Qna;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnaSaveRequest {
    private String title;
    private String content;
    private String password;
    private String tel;
    private Answer answer;

    public Qna toEntity() {
        return Qna.builder()
                .title(title).content(content).date(LocalDateTime.now())
                .password(password).tel(tel).answer(answer).build();
    }
}
