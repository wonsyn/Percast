package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Input {
    @Id
    @Column(name = "sido_code")
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
    private double rain;   // 강수량 (강수없음 = 0)
}
