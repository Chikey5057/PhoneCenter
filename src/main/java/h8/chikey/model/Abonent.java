package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "abonent")
public class Abonent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idabonent")
    private int idabonent;

    @NonNull
    @Column(name = "phone")
    private String phone;
    @NonNull
    @Column(name = "inn")
    private int inn;

    @Column(name = "photopath")
    private String photopath;

    @ManyToOne
    @JoinColumn(name = "Citi_idCiti")
    private Citi citi;

    @ManyToMany
    @JoinTable(name = "phonecall_has_abonent",
            joinColumns = @JoinColumn(name = "abonent_idabonent"),
            inverseJoinColumns = @JoinColumn(name = "phonecall_idphonecall"))
    Set<Phonecall> setPhonecall ;

    @Override
    public String toString() {
        return "Abonent{" +
                "idabonent=" + idabonent +
                ", phone='" + phone + '\'' +
                ", inn=" + inn +
                ", photopath='" + photopath + '\'' +
//                ", citi=" + citi +
                '}';
    }
}
