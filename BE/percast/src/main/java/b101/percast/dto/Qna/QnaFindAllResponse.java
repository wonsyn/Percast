package b101.percast.dto.Qna;

import b101.percast.entity.Answer;
import b101.percast.entity.Qna;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value = "전체 QnA 리스트", description = "전체 QnA 리스트에 들어갈 객체")
public class QnaFindAllResponse {
    @ApiModelProperty(value = "QnA ID")
    private Long id;
    @ApiModelProperty(value = "QnA 제목")
    private String title;
    @ApiModelProperty(value = "QnA 내용")
    private String content;
    @ApiModelProperty(value = "QnA 답변")
    private Answer answer;
    @ApiModelProperty(value = "QnA 작성 날짜")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime date;

    public QnaFindAllResponse(Qna qna) {
        this.id = qna.getId();
        this.title = qna.getTitle();
        this.content = qna.getContent();
        this.answer = qna.getAnswer();
        this.date = qna.getDate();
    }
}
