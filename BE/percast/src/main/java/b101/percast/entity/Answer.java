package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private Long id;

    @Column(name = "ans_content", nullable = false)
    private String content;
    @Column(name = "ans_date", nullable = false)
    private String date;

    @OneToOne(mappedBy = "answer")
    private Qna qna;
}
