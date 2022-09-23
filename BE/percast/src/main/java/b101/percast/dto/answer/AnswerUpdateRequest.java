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
@ApiModel(value = "수정할 Answer 객체", description = "수정할 Answer의 ID와 내용을 담고 있는 객체")
public class AnswerUpdateRequest {
    @ApiModelProperty(value = "수정할 Answer ID")
    private Long id;
    @ApiModelProperty(value = "수정할 Answer 내용")
    private String content;
}
