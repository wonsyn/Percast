package b101.percast.dto.input;

import b101.percast.entity.Input;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InputSaveRequest {
    private Long sidoCode;
    private double so2;    // 아황산가스
    private double co;     // 일산화탄소
    private double o3;     // 오존
    private double no2;    // 이산화질소
    private double pm10;   // 미세먼지
    private double tempAvg;    // 1시간 기온
    private double tempMin;    // 최저 온도
    private double tempMax;    // 최고 온도
    private double windAvg;    // 풍속
    private double humid;  // 습도
    private double rain;   // 강수량 (강수없음)

    public Input toEntity() {
        return Input.builder().sidoCode(sidoCode)
                .so2(so2).co(co).o3(o3).no2(no2).pm10(pm10)
                .tempAvg(tempAvg).tempMin(tempMin).tempMax(tempMax).windAvg(windAvg).humid(humid).rain(rain)
                .build();
    }
}
