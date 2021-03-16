package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Citi")
public class Citi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCiti")
    private int idCiti;
    @NonNull
    @Column(name = "name")
    private String name;
    @NonNull
    @Column(name = "tarifday")
    private int tarifday;

    @NonNull
    @Column(name = "tarifnigth")
    private int tarifnigth;

    @OneToMany(mappedBy = "citi")
    Set<Abonent> setCiti;

    @Override
    public String toString() {
        return "Citi{" +
                "idCiti=" + idCiti +
                ", name='" + name + '\'' +
                ", tarifday=" + tarifday +
                ", tarifnigth=" + tarifnigth +
                '}';
    }
}
