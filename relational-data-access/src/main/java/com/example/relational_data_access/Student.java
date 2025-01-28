package com.example.relational_data_access;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    @JsonProperty("id")
    private long id;

    @JsonProperty("imie")
    private String imie;

    @JsonProperty("nazwisko")
    private String nazwisko;

    @JsonProperty("adres")
    private String adres;

    public Student(long id, String imie, String nazwisko, String adres) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return String.format(
                "student[id=%d, firstName='%s', lastName='%s', adres='%s']",
                id, imie, nazwisko, adres);
    }
}