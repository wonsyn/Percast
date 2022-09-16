package b101.percast.dto.Qna;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnaUpdateRequest {
        private Long id;
        private String title;
        private String content;
        private String tel;
}
