package com.gestionprojet.pharmacie.entity.maladie;

import java.time.LocalDate;

import com.gestionprojet.pharmacie.entity.produit.Produit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="curration")
@Data
public class Curration{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String val;

    @ManyToOne
    @JoinColumn(name="id_maladie")
    Maladie maladie;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    Produit produit;

    public Curration() {
    }
}
