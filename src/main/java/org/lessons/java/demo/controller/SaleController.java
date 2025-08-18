package org.lessons.java.demo.controller;

import org.lessons.java.demo.model.Sale;
import org.lessons.java.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("sale") Sale formSale, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sales/create";
        }
        saleRepository.save(formSale);
        return "redirect:/pizze";
    }

}
