package com.example.springJPA.entity;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tbl_produktov")
@Data
public class Produkt {

    @Id
    @GeneratedValue
    private int id;
    private String meno;
    private int pocet;
    private double cena;
    private String znacka;


}
