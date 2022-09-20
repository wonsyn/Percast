package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Input implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long inputNum;

    @Id
    @OneToOne
    @JoinColumn(name = "sido_Code", nullable = false)
    private Sido sido;

    private double so2;    // 아황산가스
    private double co;     // 일산화탄소
    private double o3;     // 오존
    private double no2;    // 이산화질소
    private double pm10;   // 미세먼지
    private int tempAvg;    // 1시간 기온
    private int tempMin;    // 최저 온도
    private int tempMax;    // 최고 온도
    private double windAvg;    // 풍속
    private int humid;  // 습도
    private int rain;   // 강수량 (강수없음)
}
