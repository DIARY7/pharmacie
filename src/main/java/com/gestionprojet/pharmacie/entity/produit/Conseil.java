package com.gestionprojet.pharmacie.entity.produit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Conseil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int mois;
    int annee;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    Produit produit;

    public Conseil() {
    }
    public Conseil(int mois, int annee, Produit produit) {
        this.mois = mois;
        this.annee = annee;
        this.produit = produit;
    }
}
