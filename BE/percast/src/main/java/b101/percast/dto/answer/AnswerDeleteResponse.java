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
@ApiModel(value = "삭제 응답 객체", description = "Answer 삭제 성공 메시지를 담고있는 객체")
public class AnswerDeleteResponse {
    @ApiModelProperty(value = "삭제 성공: true, 실패: 응답코드 발생(204-No Content)")
    boolean success;
}
