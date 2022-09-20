package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Sido {
    @Id
    @Column(name = "sido_code")
    private Long sidoCode;

    @Column(name = "sido_name",nullable = false, columnDefinition = "varchar(20)")
    private String sidoName;
    private int nx;
    private int ny;
}
