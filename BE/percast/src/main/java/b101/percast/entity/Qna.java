package b101.percast.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@DynamicInsert
@DynamicUpdate
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id")
    private Long id;

    @Column(name = "qna_title", nullable = false)
    private String title;
    @Column(name = "qna_content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "qna_date", nullable = true, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private String date;
    @Column(name = "qna_password", nullable = false)
    private String password;
    @Column(name = "qna_tel")
    private String tel;

    @OneToOne
    @JoinColumn(name = "ans_id")
    private Answer answer;
}
