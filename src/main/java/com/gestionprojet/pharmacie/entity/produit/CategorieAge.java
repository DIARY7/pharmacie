package com.gestionprojet.pharmacie.entity.produit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "categorie_age")
@Data
public class CategorieAge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String val; 
    
    int ageMin;
    int ageMax;

    public CategorieAge() {
    }
}

