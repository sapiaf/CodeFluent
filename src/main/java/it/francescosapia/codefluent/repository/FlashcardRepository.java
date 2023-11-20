package it.francescosapia.codefluent.repository;

import it.francescosapia.codefluent.model.Flashcard;
import it.francescosapia.codefluent.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {
}
