package it.francescosapia.codefluent.api;

import it.francescosapia.codefluent.model.Flashcard;
import it.francescosapia.codefluent.repository.FlashcardRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/flashcards")
public class FlashcardRestController {
    @Autowired
    private FlashcardRepository flashcardRepository;
    @GetMapping
    public List<Flashcard> list() {
        List<Flashcard> flashcards = flashcardRepository.findAll();
        return flashcards;
    }
    @GetMapping("/{id}")
    public Flashcard detail(@PathVariable("id") Integer id) {
        Optional<Flashcard> result = flashcardRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flashcard with id " + id + " not found");
        }
    }
    @PostMapping
    public Flashcard create(@Valid @RequestBody Flashcard flashcard) {
        Flashcard createdFlashcard = flashcardRepository.save(flashcard);
        return createdFlashcard;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Optional<Flashcard> result = flashcardRepository.findById(id);
        if (result.isPresent()) {
            try {
                flashcardRepository.deleteById(id);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Flashcard with id " + id + " cannot be deleted");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flashcard with id " + id + " not found");
        }
    }
    @PutMapping("/{id}")
    public Flashcard update(@Valid @RequestBody Flashcard flashcard, @PathVariable Integer id) {
        Optional<Flashcard> result = flashcardRepository.findById(id);
        if (result.isPresent()) {
            flashcard.setId(id);
            return flashcardRepository.save(flashcard);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flashcard with id " + id + " not found");
        }
    }
}
