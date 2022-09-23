package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ApiModel(value = "공지사항 삭제 정보", description = "공지사항 번호를 통한 글삭제 요청에 사용되는 DTO입니다.")
public class NoticeDeleteByIdRequestDto {
    private Long id;

    /* DTO -> Entity */
    public Notice toEntity() {
        return Notice.builder()
                .id(id)
                .build();
    }

}
