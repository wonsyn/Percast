package b101.percast.dto;

import b101.percast.entity.Answer;
import b101.percast.entity.Qna;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QnaDto {
    private Long id;
    private String title;
    private String content;

    private String date;
    private String password;
    private String tel;
    private Answer answer;

    @Builder
    public QnaDto(Long id, String title, String content, String date, String password, String tel, Answer answer) {
        this.id = id; this.title = title; this.content = content; this.date = date;
        this.password = password; this.tel = tel; this.answer = answer;
    }

    public Qna toEntity() {
        return Qna.builder()
                .id(id)
                .title(title)
                .content(content)
                .date(date)
                .password(password)
                .tel(tel)
                .answer(answer)
                .build();
    }
}
