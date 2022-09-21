package b101.percast.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;
    @Column(name = "message_tel", columnDefinition = "varchar(20)")
    private String tel;
    @Column(name = "message_disease", columnDefinition = "varchar(20)")
    private String disease;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "message_sidocode")
    private Long sidoCode;
}
