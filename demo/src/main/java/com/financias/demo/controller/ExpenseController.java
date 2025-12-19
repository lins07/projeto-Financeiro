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

    // O @GetMapping indica que quando o navegador acessar esta URL, o código abaixo roda
@GetMapping("/despesas/excluir/{id}")
public String excluirDespesa(@PathVariable Long id) {
    
    // 1. O @PathVariable pega o número (ID) que vem na URL (ex: /excluir/5)
    // 2. O repository executa o comando SQL "DELETE FROM expense WHERE id = id"
    repo.deleteById(id);
    
    // 3. Após apagar, ele redireciona o utilizador de volta para a lista atualizada
    return "redirect:/despesas";
}
}