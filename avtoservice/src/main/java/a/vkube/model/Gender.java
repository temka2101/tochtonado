package a.vkube.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "gender")
public class Gender {

    @Id
    @NonNull
    @Column(name = "Code")
    private char genderCode;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "gender", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Client>clientSet;

    @Override
    public String toString() {
        return String.format(name);
    }
}
