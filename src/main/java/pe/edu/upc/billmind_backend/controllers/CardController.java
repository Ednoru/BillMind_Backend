package pe.edu.upc.billmind_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.billmind_backend.domain.models.Card;
import pe.edu.upc.billmind_backend.domain.services.CardService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        Card card = cardService.getCardById(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Card> saveCard(@RequestBody Card card) {
        Card savedCard = cardService.addCard(card);
        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCard(@RequestBody Card card) {
        cardService.updateCard(card);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
