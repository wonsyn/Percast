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
@ApiModel(value = "QnA 삭제 결과 객체", description = "QnA 삭제 결과를 담아 보여주는 객체")
public class QnaDeleteResponse {
    @ApiModelProperty(value = "QnA 삭제 결과")
    boolean success;
}
