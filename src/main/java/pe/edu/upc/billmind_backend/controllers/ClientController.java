package pe.edu.upc.billmind_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.billmind_backend.domain.models.*;
import pe.edu.upc.billmind_backend.domain.services.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;
    private final CardService cardService;
    private final DebtsService debtService;
    private final ReminderService reminderService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public ClientController(
            ClientService clientService,
            CardService cardService,
            DebtsService debtService,
            ReminderService reminderService,
            SubscriptionService subscriptionService
    ) {
        this.clientService = clientService;
        this.cardService = cardService;
        this.debtService = debtService;
        this.reminderService = reminderService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/{clientId}/cards")
    public ResponseEntity<List<Card>> getCardsByClientId(@PathVariable Client clientId) {
        List<Card> cards = cardService.getCardsByClientId(clientId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{clientId}/debts")
    public ResponseEntity<List<Debts>> getDebtsByClientId(@PathVariable Client clientId) {
        List<Debts> debts = debtService.getDebtsByClientId(clientId);
        return new ResponseEntity<>(debts, HttpStatus.OK);
    }

    @GetMapping("/{clientId}/reminders")
    public ResponseEntity<List<Reminder>> getRemindersByClientId(@PathVariable Client clientId) {
        List<Reminder> reminders = reminderService.getRemindersByClientId(clientId);
        return new ResponseEntity<>(reminders, HttpStatus.OK);
    }

    @GetMapping("/{clientId}/subscriptions")
    public ResponseEntity<List<Subscription>> getSubscriptionsByClientId(@PathVariable Client clientId) {
        List<Subscription> subscriptions = subscriptionService.getSubscriptionsByClientId(clientId);
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        Client savedClient = clientService.addClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
