package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Output{
    @Id
    @Column(name = "sidoCode")
    private Long sidoCode;
    private int temperature;
    private double cold;
    private double asthma;
    private double skin;
    private double eye;
    private double foodPoison;
}
