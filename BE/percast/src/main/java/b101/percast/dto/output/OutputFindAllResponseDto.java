package b101.percast.dto.output;

import b101.percast.entity.Output;
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
@ApiModel(value = "위험지수 정보", description = "감기, 천식, 피부병, 눈병, 식중독 위험지수를 담고 있는 DTO 클래스")
public class OutputFindAllResponseDto {
    @ApiModelProperty(value = "감기 위험지수")
    private int cold;
    @ApiModelProperty(value = "천식 위험지수")
    private int asthma;
    @ApiModelProperty(value = "피부병 위험지수")
    private int skin;
    @ApiModelProperty(value = "눈병 위험지수")
    private int eye;
    @ApiModelProperty(value = "식중독 위험지수")
    private int foodPoison;

    public OutputFindAllResponseDto(Output Entity) {
        this.cold = (int)Entity.getCold();
        this.asthma = (int)Entity.getAsthma();
        this.skin = (int)Entity.getSkin();
        this.eye = (int)Entity.getEye();
        this.foodPoison = (int)Entity.getFoodPoison();
    }
}
