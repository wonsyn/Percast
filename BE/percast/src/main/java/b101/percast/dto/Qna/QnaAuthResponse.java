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
@ApiModel(value = "인증 응답 객체", description = "인증 성공과 실패를 담고있는 객체")
public class QnaAuthResponse {
    @ApiModelProperty(value = "인증 성공: true, 인증 실패: false")
    boolean success;
}
