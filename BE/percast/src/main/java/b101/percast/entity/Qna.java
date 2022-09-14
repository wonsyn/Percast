package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id")
    private Long id;

    @Column(name = "qna_title", nullable = false)
    private String title;
    @Column(name = "qna_content", nullable = false)
    private String content;
    @Column(name = "qna_date", nullable = false)
    private String date;
    @Column(name = "qna_password", nullable = false)
    private String password;
    @Column(name = "qna_tel")
    private String tel;

    @OneToOne
    @JoinColumn(name = "ans_id")
    private Answer answer;
}
