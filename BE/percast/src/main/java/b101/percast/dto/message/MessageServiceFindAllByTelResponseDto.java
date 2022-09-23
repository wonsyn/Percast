package b101.percast.dto.message;


import b101.percast.entity.MessageService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageServiceFindAllByTelResponseDto {

    private Long id;
    private String tel;
    private String disease;
    private Long sidoCode;

    /* Entity -> DTO */
    public MessageServiceFindAllByTelResponseDto(MessageService entity){
        this.id = entity.getId();
        this.tel = entity.getTel();
        this.disease = entity.getDisease();
        this.sidoCode = entity.getSidoCode();
    }
}
