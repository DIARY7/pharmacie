package com.gestionprojet.pharmacie.entity.produit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "type_produit")
@Data
public class TypeProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String val;
    
    public TypeProduit() {
    }

    public TypeProduit(String val) {
        this.val = val;
    }
    
}
