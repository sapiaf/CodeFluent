package it.francescosapia.codefluent.controller;


import it.francescosapia.codefluent.model.Deck;
import it.francescosapia.codefluent.model.User;
import it.francescosapia.codefluent.repository.DeckRepository;
import it.francescosapia.codefluent.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/decks")
public class DeckController {
    @Autowired
    private DeckRepository deckRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/{deckId}")
    public String detail(@PathVariable("deckId") Integer id, Model model) {
        Optional<Deck> deckOptional = deckRepository.findById(id);

        if (deckOptional.isPresent()) {

            Deck deck = deckOptional.get();
            model.addAttribute("deck", deck);
            model.addAttribute("cards", deck.getFlashcards());
            return "decks/detail";

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/create")
    public String create() {
        return "decks/create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("deck") Deck deck, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "decks/create";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserEmail = authentication.getName();
        Optional<User> loggedInUserOptional = userRepository.findByEmail(loggedInUserEmail);
        if (loggedInUserOptional.isPresent()) {
            User loggedInUser = loggedInUserOptional.get();
            deck.setUser(loggedInUser);
            deckRepository.save(deck);
            return "redirect:/decks/" + deck.getId();
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Deck> deck = deckRepository.findById(id);
        if (deck.isPresent()) {
            model.addAttribute("deck", deck.get());
            return "decks/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "deck with id " + id + " not found");
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("deck") Deck deck, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "decks/edit";
        }
        deckRepository.save(deck);
        return "redirect:/decks/" + id;
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        deckRepository.deleteById(id);
        return "redirect:/";
    }

}
