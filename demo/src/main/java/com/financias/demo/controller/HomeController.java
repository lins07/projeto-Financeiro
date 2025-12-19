package com.financias.demo.controller;

import com.financias.demo.model.Expense;
import com.financias.demo.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/home")
    public String home(Model model) {
        BigDecimal totalGasto = BigDecimal.ZERO;

        try {
            List<Expense> despesas = expenseRepository.findAll();
            if (despesas != null && !despesas.isEmpty()) {
                for (Expense d : despesas) {
                    if (d.getAmount() != null) {
                        totalGasto = totalGasto.add(d.getAmount());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao calcular total: " + e.getMessage());
        }

        // Importante: o nome aqui deve ser exatamente "totalGasto"
        model.addAttribute("totalGasto", totalGasto);
        return "home";
    }
}