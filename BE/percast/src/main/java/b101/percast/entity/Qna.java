package b101.percast.entity;

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
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id")
    private Long id;

    @Column(name = "qna_title", nullable = false)
    private String title;
    @Column(name = "qna_content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "qna_date", nullable = false)
    @CreatedDate
    private LocalDateTime date;

    @Column(name = "qna_password", nullable = false)
    private String password;
    @Column(name = "qna_tel")
    private String tel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ans_id")
    private Answer answer;

    public Qna update(String title, String content){
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
        return this;
    }

    public void updateAnswer(Answer answer){
        this.answer = answer;
    }
}
