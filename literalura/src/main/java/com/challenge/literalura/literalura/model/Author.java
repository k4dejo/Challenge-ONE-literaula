package com.challenge.literalura.literalura.model;

import jakarta.persistence.*;

@Entity
public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;
        private String lastName;
        private String nationality;
        private String birthYear;

        // Constructor, getters y setters

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getNationality() {
                return nationality;
        }

        public void setNationality(String nationality) {
                this.nationality = nationality;
        }

        public String getBirthYear() {
                return birthYear;
        }

        public void setBirthYear(String birthYear) {
                this.birthYear = birthYear;
        }
}