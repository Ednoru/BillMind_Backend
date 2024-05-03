package pe.edu.upc.billmind_backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.billmind_backend.domain.models.Client;
import pe.edu.upc.billmind_backend.domain.models.Reminder;

import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByClientId(Client Client_id);
}
