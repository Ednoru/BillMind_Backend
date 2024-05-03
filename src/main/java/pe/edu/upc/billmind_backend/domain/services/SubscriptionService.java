package pe.edu.upc.billmind_backend.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.billmind_backend.domain.models.Client;
import pe.edu.upc.billmind_backend.domain.models.Subscription;
import pe.edu.upc.billmind_backend.domain.repositories.SubscriptionRepository;

import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public List<Subscription> getSubscriptionsByClientId(Client clientId) {
        return subscriptionRepository.findByClientId(clientId);
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    public Subscription getSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId).orElse(null);
    }
}
