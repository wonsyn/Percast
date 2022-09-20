package b101.percast.dto.output;

import b101.percast.entity.Output;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.border.EtchedBorder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutputFindAllResponseDto {
    private int temperature;
    private double cold;
    private double asthma;
    private double skin;
    private double eye;
    private double foodPoison;

    public OutputFindAllResponseDto(Output Entity) {
        this.temperature = Entity.getTemperature();
        this.cold = Entity.getCold();
        this.asthma = Entity.getAsthma();
        this.skin = Entity.getSkin();
        this.eye = Entity.getEye();
        this.foodPoison = Entity.getFoodPoison();
    }

}
