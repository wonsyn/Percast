package b101.percast.dto.Qna;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "인증할 QnA 객체", description = "인증할 QnA의 ID와 비밀번호를 담고 있는 객체")
public class QnaAuthRequest {
    @ApiModelProperty(value = "인증할 QnA의 ID")
    Long id;
    @ApiModelProperty(value = "입력받은 QnA의 비밀번호")
    String password;
}
