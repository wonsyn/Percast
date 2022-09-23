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
@ApiModel(value = "현재 대기, 날씨 정보", description = "현재 대기, 날씨 정보를 담고 있는 dto")
public class InputFindResponse {

    @ApiModelProperty(value = "온도")
    double temp;

    @ApiModelProperty(value = "습도")
    double humid;

    @ApiModelProperty(value = "강수량")
    double rain;

    @ApiModelProperty(value = "미세먼지")
    String pm10;

    @ApiModelProperty(value = "일산화탄소")
    String co;

    @ApiModelProperty(value = "오존")
    String o3;
}
