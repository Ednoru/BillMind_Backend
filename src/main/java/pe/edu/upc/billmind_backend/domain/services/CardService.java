package pe.edu.upc.billmind_backend.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.billmind_backend.domain.models.Card;
import pe.edu.upc.billmind_backend.domain.models.Client;
import pe.edu.upc.billmind_backend.domain.repositories.CardRepository;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    public void updateCard(Card card) {
        cardRepository.save(card);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    public List<Card> getCardsByClientId(Client clientId) {
        return cardRepository.findByClientId(clientId);
    }
}
