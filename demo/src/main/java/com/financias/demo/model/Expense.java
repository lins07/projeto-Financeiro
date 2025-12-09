package com.financias.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    @Column(precision = 15, scale = 2)
    private BigDecimal amount;

    private LocalDate date;
    private LocalTime time;

    private String description;

    // relacionamento com Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Expense() {}

    public Expense(String item, BigDecimal amount, LocalDate date, LocalTime time) {
        this.item = item;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Expense{" +
               "id=" + id +
               ", item='" + item + '\'' +
               ", amount=" + amount +
               ", date=" + date +
               ", time=" + time +
               ", description='" + description + '\'' +
               ", product=" + (product != null ? product.getId() : null) +
               '}';
    }
}
