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
public class Output implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long outputNum;

    @Id
    @OneToOne
    @JoinColumn(name = "sidoCode")
    private Sido sido;

    private int temperature;
    private double cold;
    private double asthma;
    private double skin;
    private double eye;
    private double foodPoison;
}
