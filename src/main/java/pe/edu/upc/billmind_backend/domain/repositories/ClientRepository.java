package pe.edu.upc.billmind_backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.billmind_backend.domain.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>
{
    Client findByMail(String mail);
}
