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
@Table(name = "categorie_produit")
@Data
public class CategorieProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String val;

    @ManyToOne
    @JoinColumn(name="id_type_produit",referencedColumnName = "id")
    TypeProduit typeProduit;

    public CategorieProduit() {
    }

    public CategorieProduit(String val, TypeProduit typeProduit) {
        this.val = val;
        this.typeProduit = typeProduit;
    }
}
