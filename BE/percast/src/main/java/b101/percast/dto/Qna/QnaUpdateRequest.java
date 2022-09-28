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
@ApiModel(value = "QnA 수정 객체", description = "수정될 QnA 정보를 담고 있는 객체")
public class QnaUpdateRequest {
        @ApiModelProperty(value = "수정할 QnA ID")
        private Long id;
        @ApiModelProperty(value = "수정할 QnA 제목")
        private String title;
        @ApiModelProperty(value = "수정할 QnA 내용")
        private String content;
}
