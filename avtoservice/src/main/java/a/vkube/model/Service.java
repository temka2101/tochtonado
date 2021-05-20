package a.vkube.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int serviceID;

    @NonNull
    @Column(name = "Title")
    private String title;

    @NonNull
    @Column(name = "Cost")
    private double cost;

    @NonNull
    @Column(name = "DurationInSeconds")
    private int durationInSeconds;

    @Column(name = "Description")
    private String description;

    @Column(name = "Discount")
    private double discount;

    @Column(name = "MainImagePath")
    private String mainImagePath;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    Set<ClientService>clientServiceSet;

    @Override
    public String toString() {
        return "Service{" +
                "serviceID=" + serviceID +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", durationInSeconds=" + durationInSeconds +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", mainImagePath='" + mainImagePath + '\'' +
                '}';
    }
}
