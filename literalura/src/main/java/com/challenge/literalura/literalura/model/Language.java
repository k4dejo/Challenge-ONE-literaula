package com.challenge.literalura.literalura.model;

import jakarta.persistence.*;

@Entity
public class Language {
    @Id
    private String code; // Código del idioma, por ejemplo "EN" para inglés

    private String name;

    // Constructor, getters y setters


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
