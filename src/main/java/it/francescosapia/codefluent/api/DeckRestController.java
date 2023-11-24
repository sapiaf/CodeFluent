package it.francescosapia.codefluent.api;

import it.francescosapia.codefluent.model.Deck;
import it.francescosapia.codefluent.model.Flashcard;
import it.francescosapia.codefluent.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/decks")
public class DeckRestController {

    @Autowired
    private DeckRepository deckRepository;

    @GetMapping("/{deckId}")
    public List<Flashcard> getAllFlashcardsForDeck(@PathVariable("deckId") Integer deckId) {
        Optional<Deck> deck = deckRepository.findById(deckId);
        if (deck.isPresent()) {
            return deck.get().getFlashcards();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deck with id " + deckId + " not found");
        }
    }

    @GetMapping("/{deckId}/flashcards/{flashcardId}")
    public Flashcard getFlashcardInDeck(@PathVariable("deckId") Integer deckId, @PathVariable("flashcardId") Integer flashcardId) {
        Optional<Deck> deck = deckRepository.findById(deckId);
        if (deck.isPresent()) {
            Optional<Flashcard> flashcard = deck.get().getFlashcards().stream()
                    .filter(card -> card.getId().equals(flashcardId))
                    .findFirst();
            if (flashcard.isPresent()) {
                return flashcard.get();
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flashcard with id " + flashcardId + " not found in Deck with id " + deckId);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deck with id " + deckId + " not found");
        }
    }
}
