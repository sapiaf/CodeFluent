package it.francescosapia.codefluent.repository;

import it.francescosapia.codefluent.model.Deck;
import it.francescosapia.codefluent.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Integer> {
    List<Deck> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
}
