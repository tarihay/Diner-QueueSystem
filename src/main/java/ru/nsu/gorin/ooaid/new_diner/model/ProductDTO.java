package ru.nsu.gorin.ooaid.new_diner.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ProductDTO {
    private String name;
    private String description;
    private int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
