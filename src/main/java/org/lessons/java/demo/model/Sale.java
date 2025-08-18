package org.lessons.java.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "sale")

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pizzeria_id", nullable = false)
    private Pizzeria pizze;

    @NotNull(message = "The start sale cannot be null")
    @PastOrPresent(message = "The start sale cannot be set in future")
    private LocalDate startSale;

    @NotNull(message = "The end sale cannot be null")
    @PastOrPresent(message = "The end sale cannot be set in future")
    private LocalDate endSale;

    @Lob
    private String notes;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pizzeria getPizze() {
        return this.pizze;
    }

    public void setPizze(Pizzeria pizze) {
        this.pizze = pizze;
    }

    public LocalDate getStartSale() {
        return this.startSale;
    }

    public void setStartSale(LocalDate startSale) {
        this.startSale = startSale;
    }

    public LocalDate getEndSale() {
        return this.endSale;
    }

    public void setEndSale(LocalDate endSale) {
        this.endSale = endSale;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
