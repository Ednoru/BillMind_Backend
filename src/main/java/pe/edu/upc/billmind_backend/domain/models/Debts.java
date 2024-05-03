package pe.edu.upc.billmind_backend.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Debts")
@Data
public class Debts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String expiration;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String relevance;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client clientId;
}
