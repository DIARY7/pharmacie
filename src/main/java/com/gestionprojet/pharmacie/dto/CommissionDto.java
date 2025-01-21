package com.gestionprojet.pharmacie.dto;

import com.gestionprojet.pharmacie.entity.vente.Commission;
import com.gestionprojet.pharmacie.entity.vente.Vendeur;

import lombok.Data;
@Data
public class CommissionDto {
    int id;
    String nom;
    double total;
    
    public CommissionDto(int id,String nom , double total) {
        this.id = id;
        this.nom = nom;
        this.total=total;
    }

}
