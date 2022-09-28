package b101.percast.dto.message;


import b101.percast.entity.MessageService;
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
@ApiModel(value = "알림 서비스 조회 결과 객체", description = "사용자의 전화번호로 조회된 알림 서비스들의 내용을 담는 객체")
public class MessageServiceFindAllByTelResponseDto {
    @ApiModelProperty(value = "알림 서비스 ID")
    private Long id;
    @ApiModelProperty(value = "사용자의 전화번호")
    private String tel;
    @ApiModelProperty(value = "등록한 질병명 (cold, eye, skin, asthma, food)")
    private String disease;
    @ApiModelProperty(value = "등록한 지역코드")
    private Long sidoCode;

    public MessageServiceFindAllByTelResponseDto(MessageService entity){
        this.id = entity.getId();
        this.tel = entity.getTel();
        this.disease = entity.getDisease();
        this.sidoCode = entity.getSidoCode();
    }
}
