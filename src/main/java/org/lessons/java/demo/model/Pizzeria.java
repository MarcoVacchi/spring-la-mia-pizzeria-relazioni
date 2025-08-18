package org.lessons.java.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizzeria")

public class Pizzeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The name mustn't be empty or null or blank, and must be min 5 char")
    private String name;

    @NotBlank(message = "The description mustn't be empty or null or blank, and must be min 10 char")
    @Lob
    private String description;

    @NotBlank(message = "The URLcode mustn't be empty or null or blank")
    private String pick;

    @NotNull
    @DecimalMin(value = "3.00", message = "Il prezzo deve essere almeno di 3 euro")
    private BigDecimal price;

    @NotBlank
    private String symbol;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPick() {
        return this.pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.name + this.description + this.pick + this.price + this.symbol;
    }

}

// Nuova importante funzionalità : le offerte speciali!
// In alcuni momenti potremmo voler vendere le nostre pizze a un prezzo
// scontato.

// Dobbiamo quindi predisporre tutto il codice necessario per poter collegare
// un’offerta speciale a una pizza (in una relazione 1 a molti, cioè un’offerta
// speciale può essere collegata a una sola pizza, e una pizza può essere
// collegata a più offerte speciali).

// L’offerta speciale avrà :

// una data di inizio
// una data di fine
// un titolo
// La pagina di dettaglio della singola pizza mostrerà l’elenco delle offerte
// collegate e avrà un bottone “Crea nuova offerta speciale” per aggiungerne una
// nuova.

// Accanto ad ogni offerta speciale è previsto un bottone che mi porterà a una
// pagina per modificarla.
