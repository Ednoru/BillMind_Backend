package pe.edu.upc.billmind_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.billmind_backend.domain.models.Subscription;
import pe.edu.upc.billmind_backend.domain.services.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
        Subscription subscription = subscriptionService.getSubscriptionById(id);
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription) {
        Subscription savedSubscription = subscriptionService.createSubscription(subscription);
        return new ResponseEntity<>(savedSubscription, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
        Subscription updatedSubscription = subscriptionService.updateSubscription(subscription);
        return new ResponseEntity<>(updatedSubscription, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
