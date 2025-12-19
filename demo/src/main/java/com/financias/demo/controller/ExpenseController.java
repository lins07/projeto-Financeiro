package com.financias.demo.controller;

import com.financias.demo.model.Expense;
import com.financias.demo.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository repo;

    @GetMapping("/despesas")
    public String list(Model model) {
        model.addAttribute("despesas", repo.findAll());
        return "despesas";
    }

    @GetMapping("/despesas/nova")
    public String form(Model model) {
        model.addAttribute("despesa", new Expense());
        return "despesa-form";
    }

    // Unificamos em apenas um método PostMapping
    @PostMapping("/despesas")
    public String save(@ModelAttribute("despesa") Expense expense) {
        repo.save(expense);
        return "redirect:/despesas";
    }
}