package b101.percast.dto.input;

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
@ApiModel(value = "대기, 날씨 정보 삽입 DTO", description = "크론식을 통한 스케줄링")
public class InputSaveResponse {
    @ApiModelProperty(value = "성공/실패 여부")
    boolean success;
}
