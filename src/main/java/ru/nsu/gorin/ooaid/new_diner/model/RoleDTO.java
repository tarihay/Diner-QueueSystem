package ru.nsu.gorin.ooaid.new_diner.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
