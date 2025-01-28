package com.gestionprojet.pharmacie.entity.vente;

import java.time.LocalDate;

import com.gestionprojet.pharmacie.entity.Livraison;

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

    double nombre; 
    LocalDate daty;

    @ManyToOne
    @JoinColumn(name="id_livraison",referencedColumnName = "id")
    Livraison livraison;
    
    @ManyToOne
    @JoinColumn(name="id_client",referencedColumnName = "id")
    Client client;
    
    public Vente(double nombre, LocalDate daty) {
        this.nombre = nombre;
        this.daty = daty;
    }
    public Vente() {
    }
}
