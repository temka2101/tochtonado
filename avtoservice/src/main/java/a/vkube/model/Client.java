package a.vkube.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int clientID;

    @NonNull
    @Column(name = "FirstName")
    private String firstName;

    @NonNull
    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Patronymic")
    private String patronymic;

    @Column(name = "Birthday")
    private LocalDate birthday;

    @NonNull
    @Column(name = "RegistrationDate")
    private LocalDate registrationDate;

    @Column(name = "Email")
    private String email;

    @NonNull
    @Column(name = "Phone")
    private String phone;

    @Column(name = "PhotoPath")
    private String photoPath;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "GenderCode")
    private Gender gender;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<ClientService>clientServiceSet;

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", gender=" + gender +
                '}';
    }
}
