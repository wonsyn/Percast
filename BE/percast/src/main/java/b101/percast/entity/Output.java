package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Output{
    @Id
    @Column(name = "sidoCode")
    private Long sidoCode;
    private double cold;
    private double asthma;
    private double skin;
    private double eye;
    private double foodPoison;

    public void updateFoodPoison(double foodPoison){
        this.foodPoison = foodPoison;
    }
}
