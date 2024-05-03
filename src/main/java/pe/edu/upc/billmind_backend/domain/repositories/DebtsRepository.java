package pe.edu.upc.billmind_backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.billmind_backend.domain.models.Client;
import pe.edu.upc.billmind_backend.domain.models.Debts;

import java.util.List;

@Repository
public interface DebtsRepository extends JpaRepository<Debts, Long> {
    List<Debts> findByClientId(Client Client_id);
}
