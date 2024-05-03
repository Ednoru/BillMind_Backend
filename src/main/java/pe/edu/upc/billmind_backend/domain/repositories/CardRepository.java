package pe.edu.upc.billmind_backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.billmind_backend.domain.models.Card;
import pe.edu.upc.billmind_backend.domain.models.Client;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByClientId(Client Client_id);
}
