package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outputNum;

    @OneToOne
    @JoinColumn(name = "gugunCode")
    private Gugun gugun;

    private int temperature;
    private double cold;
    private double asthma;
    private double skin;
    private double eye;
    private double foodPoison;
}
