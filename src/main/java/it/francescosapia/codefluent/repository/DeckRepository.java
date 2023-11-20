package it.francescosapia.codefluent.repository;

import it.francescosapia.codefluent.model.Deck;
import it.francescosapia.codefluent.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Integer> {
}
