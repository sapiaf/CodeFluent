package it.francescosapia.codefluent.controller;

import it.francescosapia.codefluent.model.Deck;
import it.francescosapia.codefluent.model.Flashcard;
import it.francescosapia.codefluent.repository.DeckRepository;
import it.francescosapia.codefluent.repository.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private DeckRepository deckRepository;
    @Autowired
    private FlashcardRepository flashcardRepository;
    @GetMapping
    public String index(Model model) {
        List<Deck> decks = deckRepository.findAll();
        model.addAttribute("decks", decks);
        return "index";
    }
    @GetMapping("/search")
    public String search(@RequestParam(value = "query", required = false) String query, Model model) {
        if (query != null && !query.isEmpty()) {
            List<Deck> foundDecks = deckRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
            List<Flashcard> foundCards = flashcardRepository.findByFrontContainingIgnoreCase(query);

            model.addAttribute("decks", foundDecks);
            model.addAttribute("cards", foundCards);
        } else {
            List<Deck> allDecks = deckRepository.findAll();
            List<Flashcard> allCards = flashcardRepository.findAll();

            model.addAttribute("decks", allDecks);
            model.addAttribute("cards", allCards);
        }
        return "info/search";
    }


    @GetMapping("/about")
    public String about() {
        return "info/about";
    }
    @GetMapping("/support")
    public String support() {
        return "info/support";
    }
    @GetMapping("/privacy")
    public String privacy() {
        return "info/privacy";
    }
    @GetMapping("/terms")
    public String terms() {
        return "info/terms";
    }

    @GetMapping("/study")
    public String study() {
        return "decks/study";
    }
    @GetMapping("/add")
    public String add() {
        return "add";
    }

}
