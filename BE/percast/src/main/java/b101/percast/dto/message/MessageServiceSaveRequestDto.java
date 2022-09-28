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
@ApiModel(value = "알림 서비스 등록 객체", description = "알림 서비스를 등록할 정보가 담긴 객체")
public class MessageServiceSaveRequestDto {
    @ApiModelProperty(value = "사용자의 전화번호 (01012341234 형태)")
    private String tel;
    @ApiModelProperty(value = "질병명 (cold, eye, skin, asthma, food)")
    private String disease; // cold, eye, skin, asthma, food
    @ApiModelProperty(value = "시도 코드 (0-16)")
    private Long sidoCode;

    public MessageService toEntity() {
        return MessageService.builder()
                .tel(tel).disease(disease).sidoCode(sidoCode).build();
    }
}
