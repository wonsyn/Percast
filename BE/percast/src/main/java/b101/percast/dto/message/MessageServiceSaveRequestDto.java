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
public class MessageServiceSaveRequestDto {
    private String tel;
    private String disease; // cold, eye, skin, asthma, food
    private Long sidoCode;

    public MessageService toEntity() {
        return MessageService.builder()
                .tel(tel).disease(disease).sidoCode(sidoCode).build();
    }
}
