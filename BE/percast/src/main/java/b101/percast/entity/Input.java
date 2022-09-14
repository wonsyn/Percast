package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inputNum;

    @OneToOne
    @JoinColumn(name = "gugunCode", nullable = false)
    private Gugun gugun;

    private int temperature;
    private double humid;
    private double micro;
    // ...
}
