package pe.edu.upc.billmind_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.billmind_backend.domain.models.Debts;
import pe.edu.upc.billmind_backend.domain.services.DebtsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/debts")
public class DebtsController {
    private final DebtsService debtService;

    @Autowired
    public DebtsController(DebtsService debtService) {
        this.debtService = debtService;
    }

    @GetMapping
    public ResponseEntity<List<Debts>> getAllDebts() {
        List<Debts> debts = debtService.getAllDebts();
        return new ResponseEntity<>(debts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Debts> getDebtById(@PathVariable Long id) {
        Debts debt = debtService.getDebtById(id);
        return new ResponseEntity<>(debt, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Debts> saveDebt(@RequestBody Debts debt) {
        Debts savedDebt = debtService.createDebt(debt);
        return new ResponseEntity<>(savedDebt, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDebt(@RequestBody Debts debt) {
        debtService.updateDebt(debt);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDebt(@PathVariable Long id) {
        debtService.deleteDebt(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
