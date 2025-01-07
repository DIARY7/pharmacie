package com.gestionprojet.pharmacie.entity;

import java.time.LocalDate;

import com.gestionprojet.pharmacie.entity.produit.Fabrication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="livraison")
@Data
public class  Livraison{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "id_fabrication")
    Fabrication fabrication;

    double prixunitaire;

    public Livraison() {
    }

}
