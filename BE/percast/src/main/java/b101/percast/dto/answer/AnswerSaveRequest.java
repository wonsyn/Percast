package b101.percast.dto.answer;

import b101.percast.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerSaveRequest {
    private String content;
    private Long qnaId;

    public Answer toEntity() {
        return Answer.builder().content(content).date(LocalDateTime.now()).build();
    }
}
