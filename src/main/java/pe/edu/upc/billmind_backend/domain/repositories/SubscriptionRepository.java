package pe.edu.upc.billmind_backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.billmind_backend.domain.models.Client;
import pe.edu.upc.billmind_backend.domain.models.Subscription;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByClientId(Client Client_id);
}
