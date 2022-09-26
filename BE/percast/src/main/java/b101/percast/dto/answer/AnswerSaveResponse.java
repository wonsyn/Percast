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
@ApiModel(value = "저장된 답변의 ID", description = "저장된 Answer의 ID를 담고 있는 객체")
public class AnswerSaveResponse {
    @ApiModelProperty(value = "저장된 답변의 ID")
    private Long id;
}
