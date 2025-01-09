package com.gestionprojet.pharmacie.entity.vente;

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
@Table(name = "vente")
@Data
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int nombre; 
    LocalDate daty;

    @ManyToOne
    @JoinColumn(name="id_fabrication",referencedColumnName = "id")
    Fabrication fabrication;
    
    @ManyToOne
    @JoinColumn(name="id_client",referencedColumnName = "id")
    Client client;
    
    public Vente() {
    }
}
