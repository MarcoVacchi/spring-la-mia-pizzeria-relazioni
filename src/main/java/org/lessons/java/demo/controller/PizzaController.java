package org.lessons.java.demo.controller;

import java.util.List;

import org.lessons.java.demo.model.Pizzeria;
import org.lessons.java.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/pizze")

public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    // index
    @GetMapping
    public String index(Model model) {

        List<Pizzeria> pizzeria = repository.findAll(); // new ArrayList<>(); --> per testare in caso sia vuoto;
        model.addAttribute("pizze", pizzeria);
        return "pizze/index";
    }

    // show
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {

        Pizzeria pizza = repository.findById(id).get();

        model.addAttribute("pizza", pizza);
        return "pizze/show";
    }

    // ricerca
    @GetMapping("/searchByName")
    public String searchByName(@RequestParam(name = "name") String name, Model model) {
        List<Pizzeria> pizzeria = repository.findByNameContainingIgnoreCase(name);
        model.addAttribute("pizze", pizzeria);
        model.addAttribute("name", name);
        return "pizze/index";
    }

    // creazione

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizze", new Pizzeria());
        return "pizze/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizze") Pizzeria formPizzeria, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "pizze/create";
        }
        repository.save(formPizzeria);
        return "redirect:/pizze";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("pizze", repository.findById(id).get());
        return "pizze/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("pizze") Pizzeria formPizzeria, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "pizze/edit";
        }
        repository.save(formPizzeria);
        return "redirect:/pizze";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        repository.deleteById(id);
        return "redirect:/pizze";
    }

}

// Completiamo le pagine di gestione delle nostre pizze!

// Abbiamo la pagina con la lista di tutte le pizze, quella con i dettagli della
// singola pizza, quella per crearla...cosa manca?

// Dobbiamo realizzare :
// pagina di modifica di una pizza
// cancellazione di una pizza, cliccando un pulsante presente nella grafica di
// ogni singolo prodotto mostrato (nella lista in index)