package b101.percast.dto.answer;

import b101.percast.entity.Answer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "저장할 Answer 객체", description = "저장할 Answer의 정보를 담고 있는 객체")
public class AnswerSaveRequest {
    @ApiModelProperty(value = "저장할 Answer 내용")
    private String content;
    @ApiModelProperty(value = "해당 답변이 달릴 QnA ID")
    private Long qnaId;

    public Answer toEntity() {
        return Answer.builder().content(content).date(LocalDateTime.now()).build();
    }
}
