package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Setter
@Entity
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "phonecall")
public class Phonecall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idphonecall")
    private int idphonecall;

    @NonNull
    @Column(name = "date")
    private Date date;

    @NonNull
    @Column(name = "minutecoll")
    private int minutecoll;

    @NonNull
    @Column(name = "timeday")
    private Date timeday;

    @ManyToMany
    @JoinTable(name = "phonecall_has_abonent")
    Set<Abonent> setAbonent ;


    @Override
    public String toString() {
        return "Phonecall{" +
                "idphonecall=" + idphonecall +
                ", date=" + date +
                ", minutecoll=" + minutecoll +
                ", timeday=" + timeday +
                '}';
    }
}
