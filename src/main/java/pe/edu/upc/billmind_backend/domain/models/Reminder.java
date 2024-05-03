package pe.edu.upc.billmind_backend.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Reminder")
@Data
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String end_reminder;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client clientId;
}
