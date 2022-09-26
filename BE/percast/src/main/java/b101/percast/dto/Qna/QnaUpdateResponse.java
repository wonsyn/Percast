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
@ApiModel(value = "QnA 수정 응답 객체", description = "수정에 성공한 QnA의 ID를 담아 보여주는 객체")
public class QnaUpdateResponse {
    @ApiModelProperty(value = "수정된 QnA ID")
    Long id;
}
