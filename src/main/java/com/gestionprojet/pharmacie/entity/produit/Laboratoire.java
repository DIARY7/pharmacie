package com.gestionprojet.pharmacie.entity.produit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "laboratoire")
@Data
public class Laboratoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    String lieu;
    public Laboratoire(String nom, String lieu) {
        this.nom = nom;
        this.lieu = lieu;
    }
    public Laboratoire() {
    }
}
