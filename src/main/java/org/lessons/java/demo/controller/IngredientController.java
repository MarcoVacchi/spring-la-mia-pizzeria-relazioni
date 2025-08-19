package org.lessons.java.demo.controller;

import org.lessons.java.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    public String index(Model model) {
        model.addAttribute("ingredient", ingredientRepository.findAll());
        return "ingredients/index";
    }
}
