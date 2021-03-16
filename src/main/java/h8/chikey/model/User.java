package h8.chikey.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int iduser;
    @NonNull
    @Column(name = "login")
    private String login;
    @NonNull
    @Column(name = "password")
    private String password;


    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
