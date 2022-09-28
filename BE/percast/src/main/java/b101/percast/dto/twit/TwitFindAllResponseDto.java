package b101.percast.dto.twit;

import b101.percast.entity.Notice;
import b101.percast.entity.Twit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Twit 크롤링 결과 리스트"
        , description = "Twit 크롤링 결과 리스트를 담고있는 객체")
public class TwitFindAllResponseDto {
    
    @ApiModelProperty(value = "Twit ID")
    private Long id;

    @ApiModelProperty(value = "Twit 질병명")
    private String disease;

    @ApiModelProperty(value = "Twit 횟수")
    private Long count;

    @ApiModelProperty(value = "Twit 키워드")
    private String keyword;

    /* Entity -> DTO */
    public TwitFindAllResponseDto(Twit entity){
        this.id = entity.getId();
        this.disease = entity.getDisease();
        this.count = entity.getCount();
        this.keyword = entity.getKeyword();
    }
}
