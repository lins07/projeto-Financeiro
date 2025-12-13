package com.financias.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.financias.demo.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {}

