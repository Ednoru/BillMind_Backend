package pe.edu.upc.billmind_backend.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;
}
