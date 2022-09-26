package b101.percast.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ApiModel(value = "Answer Entity", description = "Answer의 정보를 담고 있는 Entity")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    @ApiModelProperty(value = "Answer ID")
    private Long id;

    @Column(name = "ans_content", nullable = false)
    @ApiModelProperty(value = "Answer 내용")
    private String content;
    @Column(name = "ans_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @CreatedDate
    @ApiModelProperty(value = "Answer 작성일자")
    private LocalDateTime date;

    public Answer update(String content) {
        this.content = content; this.date = LocalDateTime.now();
        return this;
    }
}
