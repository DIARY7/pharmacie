package com.gestionprojet.pharmacie.entity.vente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "vendeur")
@Data
public class Vendeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nom;

    @ManyToOne
    @JoinColumn(name="id_sexe",referencedColumnName = "id")
    Sexe sexe;
    

    public Vendeur() {
    }
}
