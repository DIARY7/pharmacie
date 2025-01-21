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
@Table(name = "commisssion")
@Data
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    double prixCommission; 

    @ManyToOne
    @JoinColumn(name="id_vendeur",referencedColumnName = "id")
    Vendeur vendeur;
    
    @ManyToOne
    @JoinColumn(name="id_vente",referencedColumnName = "id")
    Vente vente;
    
    public Commission() {
    }
}
