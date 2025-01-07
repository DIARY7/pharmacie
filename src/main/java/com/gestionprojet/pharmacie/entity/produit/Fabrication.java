package com.gestionprojet.pharmacie.entity.produit;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Fabrication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    Produit produit;

    LocalDate dateFabrication;
    LocalDate datePeremption;
    
    public Fabrication() {
    }

    public Fabrication(LocalDate dateFabrication, LocalDate datePeremption) {
        this.dateFabrication = dateFabrication;
        this.datePeremption = datePeremption;
    }

}
