package b101.percast.dto.twit;

import b101.percast.entity.Notice;
import b101.percast.entity.Twit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TwitFindAllResponseDto {
    private Long id;
    private String disease;
    private Long count;
    private String keyword;

    /* Entity -> DTO */
    public TwitFindAllResponseDto(Twit entity){
        this.id = entity.getId();
        this.disease = entity.getDisease();
        this.count = entity.getCount();
        this.keyword = entity.getKeyword();
    }
}
