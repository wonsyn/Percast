package b101.percast.dto.input;

import b101.percast.entity.Input;
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
@ApiModel(value = "대기, 날씨 정보 요청 DTO")
public class InputSaveRequest {

    @ApiModelProperty(value = "시도 코드")
    private Long sidoCode;

    @ApiModelProperty(value = "아황산가스")
    private double so2;

    @ApiModelProperty(value = "일산화탄소")
    private double co;

    @ApiModelProperty(value = "오존")
    private double o3;

    @ApiModelProperty(value = "이산화질소")
    private double no2;

    @ApiModelProperty(value = "미세먼지")
    private double pm10;

    @ApiModelProperty(value = "1시간 기온")
    private double tempAvg;

    @ApiModelProperty(value = "최저 온도")
    private double tempMin;

    @ApiModelProperty(value = "최고 온도")
    private double tempMax;

    @ApiModelProperty(value = "풍속")
    private double windAvg;

    @ApiModelProperty(value = "습도")
    private double humid;

    @ApiModelProperty(value = "강수량 (강수없음)")
    private double rain;

    public Input toEntity() {
        return Input.builder().sidoCode(sidoCode)
                .so2(so2).co(co).o3(o3).no2(no2).pm10(pm10)
                .tempAvg(tempAvg).tempMin(tempMin).tempMax(tempMax).windAvg(windAvg).humid(humid).rain(rain)
                .build();
    }
}
