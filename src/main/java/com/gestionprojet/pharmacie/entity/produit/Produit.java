package com.gestionprojet.pharmacie.entity.produit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="produit")
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    String description;
    @ManyToOne
    @JoinColumn(name = "id_categorie_produit")
    CategorieProduit categorieProduit;

    @ManyToOne
    @JoinColumn(name = "id_categorie_age")
    CategorieAge categorieAge;

    @ManyToOne
    @JoinColumn(name = "id_laboratoire")
    Laboratoire laboratoire;

    public Produit() {
    
    }
    public Produit(String nom, String description, CategorieProduit categorieProduit) {
        this.nom = nom;
        this.description = description;
        this.categorieProduit = categorieProduit;
    }
    

}
