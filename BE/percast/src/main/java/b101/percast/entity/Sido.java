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

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String sidoName;
    private int nx;
    private int ny;
}
