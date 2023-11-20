package it.francescosapia.codefluent.controller;

import it.francescosapia.codefluent.model.Deck;
import it.francescosapia.codefluent.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private DeckRepository deckRepository;
    @GetMapping
    public String index(Model model) {
        List<Deck> decks = deckRepository.findAll();
        model.addAttribute("decks", decks);
        return "index";
    }
    @GetMapping("/about")
    public String about() {
        return "info/about";
    }
    @GetMapping("/search")
    public String search() {
        return "info/search";
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
        return "study";
    }
    @GetMapping("/add")
    public String add() {
        return "add";
    }

}
