package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ApiModel(value = "공지사항 저장 요청 정보", description = "공지사항 글 저장을 요청하는 DTO 입니다.")
public class NoticeSaveRequestDto {
    @ApiModelProperty(value = "글 번호")
    private Long id;

    @ApiModelProperty(value = "글 제목")
    private String title;

    @ApiModelProperty(value = "글 내용")
    private String content;

    /* DTO -> Entity */
    public Notice toEntity() {
        return Notice.builder()
                .id(id)
                .title(title)
                .content(content)
                .date(LocalDateTime.now())
                .build();
    }

}
