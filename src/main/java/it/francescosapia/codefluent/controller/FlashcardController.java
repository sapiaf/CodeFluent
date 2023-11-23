package it.francescosapia.codefluent.controller;

import it.francescosapia.codefluent.model.Deck;
import it.francescosapia.codefluent.model.Tag;
import it.francescosapia.codefluent.repository.DeckRepository;
import it.francescosapia.codefluent.repository.FlashcardRepository;
import it.francescosapia.codefluent.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
}
