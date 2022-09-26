package b101.percast.dto.Qna;

import b101.percast.entity.Qna;
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
@ApiModel(value = "QnA 작성 객체", description = "작성할 QnA의 정보가 담겨있는 객체")
public class QnaSaveRequest {
    @ApiModelProperty(value = "QnA 제목")
    private String title;
    @ApiModelProperty(value = "QnA 내용")
    private String content;
    @ApiModelProperty(value = "QnA 비밀번호")
    private String password;

    public Qna toEntity() {
        return Qna.builder()
                .title(title).content(content).date(LocalDateTime.now())
                .password(password).answer(null).build();
    }
}
