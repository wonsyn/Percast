//package b101.percast.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Gugun{
//    @Id
//    private Long gugunCode;
//    @ManyToOne
//    @JoinColumn(name = "sidoCode")
//    private Sido sido;
//
//    @Column(nullable = false)
//    private String gugunName;
//    private int nx;
//    private int ny;
//
//    @OneToOne(mappedBy = "gugun")
//    private Input input;
//    @OneToOne(mappedBy = "gugun")
//    private Output output;
//}
