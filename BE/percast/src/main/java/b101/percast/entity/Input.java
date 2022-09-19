package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Input implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long inputNum;

    @Id
    @OneToOne
    @JoinColumn(name = "sidoCode", nullable = false)
    private Sido sido;

    private int temperature;
    private double humid;
    private double micro;
    // ...
}
