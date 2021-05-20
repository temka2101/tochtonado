package a.vkube.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "clientservice")
public class ClientService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int clientserviceID;

    @NonNull
    @Column(name = "StartTime")
    private Date startTime;

    @Column(name = "Comment")
    private String comment;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ClientID")
    private Client client;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ServiceID")
    private Service service;

    @Override
    public String toString() {
        return "ClientService{" +
                "clientserviceID=" + clientserviceID +
                ", startTime=" + startTime +
                ", comment='" + comment + '\'' +
                ", client=" + client +
                ", service=" + service +
                '}';
    }
}
