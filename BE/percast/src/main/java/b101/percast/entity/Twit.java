package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Twit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "twit_id")
    private Long id;
    @Column(name = "twit_disease", columnDefinition = "varchar(20)")
    private String disease;
    @Column(name = "twit_count")
    private Long count;
    @Column(name = "twit_keyword")
    private String keyword;
}
