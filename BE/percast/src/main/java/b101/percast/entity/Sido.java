package b101.percast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sido {
    @Id
    private Long sidoCode;

    @Column(nullable = false)
    private String sidoName;
    @OneToMany(mappedBy = "sido")
    private List<Gugun> guguns = new ArrayList<>();
}
