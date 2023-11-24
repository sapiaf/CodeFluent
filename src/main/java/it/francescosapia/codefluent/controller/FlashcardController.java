package it.francescosapia.codefluent.controller;

import it.francescosapia.codefluent.model.Deck;
import it.francescosapia.codefluent.model.Flashcard;
import it.francescosapia.codefluent.model.Tag;
import it.francescosapia.codefluent.repository.DeckRepository;
import it.francescosapia.codefluent.repository.FlashcardRepository;
import it.francescosapia.codefluent.repository.TagRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("cards")
public class FlashcardController {
    @Autowired
    private FlashcardRepository flashcardRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private DeckRepository deckRepository;

    @GetMapping
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Tag> tags = tagRepository.findAll();
        List<Deck> decks = deckRepository.findAll();


        model.addAttribute("tags", tags);
        model.addAttribute("decks", decks);
        return "cards/create";
    }
    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("flashcard") Flashcard flashcard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/cards/create";
        }
        flashcard.setCreationDate(LocalDate.now());
        flashcard.setDueDate(LocalDateTime.now());
        flashcardRepository.save(flashcard);
        return "redirect:/decks/" + flashcard.getDeck().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Flashcard> flashcard = flashcardRepository.findById(id);
        List<Deck> decks = deckRepository.findAll();
        List<Tag> tags = tagRepository.findAll();

        if (flashcard.isPresent()) {
            model.addAttribute("flashcard", flashcard.get());
            model.addAttribute("decks", decks);
            model.addAttribute("tags", tags);
            return "cards/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "flashcard with id " + id + " not found");
        }
    }
    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("flashcard") Flashcard flashcard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/cards/edit/" + id;
        }
        flashcardRepository.save(flashcard);
        return "redirect:/decks/" + flashcardRepository.findById(id).get().getDeck().getId();
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        Optional<Flashcard> flashcardOptional = flashcardRepository.findById(id);
        if (flashcardOptional.isPresent()) {
            Flashcard flashcard = flashcardOptional.get();
            Integer deckId = flashcard.getDeck().getId();
            flashcardRepository.deleteById(id);
            return "redirect:/decks/" + deckId;
        } else {
            return "redirect:/";
        }
    }


}
