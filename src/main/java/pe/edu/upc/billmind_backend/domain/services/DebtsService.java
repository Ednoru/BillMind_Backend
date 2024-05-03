package pe.edu.upc.billmind_backend.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.billmind_backend.domain.models.Client;
import pe.edu.upc.billmind_backend.domain.models.Debts;
import pe.edu.upc.billmind_backend.domain.repositories.DebtsRepository;

import java.util.List;

@Service
public class DebtsService {
    private final DebtsRepository debtsRepository;

    public DebtsService(DebtsRepository debtsRepository) {
        this.debtsRepository = debtsRepository;
    }

    public List<Debts> getAllDebts() {
        return debtsRepository.findAll();
    }

    public List<Debts> getDebtsByClientId(Client clientId) {
        return debtsRepository.findByClientId(clientId);
    }

    public Debts createDebt(Debts debt) {
        return debtsRepository.save(debt);
    }

    public void updateDebt(Debts debt) {
        debtsRepository.save(debt);
    }

    public void deleteDebt(Long debtId) {
        debtsRepository.deleteById(debtId);
    }

    public Debts getDebtById(Long debtId) {
        return debtsRepository.findById(debtId).orElse(null);
    }
}
