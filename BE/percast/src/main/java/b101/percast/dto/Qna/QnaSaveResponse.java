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
@ApiModel(value = "작성된 QnA", description = "작성된 QnA의 id를 반환하는 객체")
public class QnaSaveResponse {
    @ApiModelProperty(value = "QnA ID")
    Long id;
}
