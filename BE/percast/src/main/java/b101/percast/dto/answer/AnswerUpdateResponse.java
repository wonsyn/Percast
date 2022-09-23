package b101.percast.dto.answer;

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
@ApiModel(value = "수정된 답변의 ID", description = "수정된 답변의 ID를 담고 있는 객체")
public class AnswerUpdateResponse {
    @ApiModelProperty(value = "수정된 답변의 ID")
    private Long id;
}
