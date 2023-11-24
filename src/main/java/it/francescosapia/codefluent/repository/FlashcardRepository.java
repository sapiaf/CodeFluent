package it.francescosapia.codefluent.repository;

import it.francescosapia.codefluent.model.Flashcard;
import it.francescosapia.codefluent.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {
    List<Flashcard> findByFrontContainingIgnoreCase(String front);
}
