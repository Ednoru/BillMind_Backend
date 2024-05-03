package pe.edu.upc.billmind_backend.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Subscription")
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String initial_date;

    @Column(nullable = false)
    private String end_date;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client clientId;
}
