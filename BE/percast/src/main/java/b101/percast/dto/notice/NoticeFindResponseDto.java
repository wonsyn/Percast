package b101.percast.dto.notice;

import b101.percast.entity.Notice;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "공지사항 글 상세조회", description = "공지사항 글 상세조회 대한 DTO 입니다.")
public class NoticeFindResponseDto {
    @ApiModelProperty(value = "글 번호")
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "등록 일시")
    private LocalDateTime date;

    @ApiModelProperty(value = "글 제목")
    private String title;

    @ApiModelProperty(value = "글 내용")
    private String content;

    public NoticeFindResponseDto(Notice entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
