package com.gestionprojet.pharmacie.entity.vente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sexe")
@Data
public class Sexe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String valeur;
    public Sexe() {
    }
}
