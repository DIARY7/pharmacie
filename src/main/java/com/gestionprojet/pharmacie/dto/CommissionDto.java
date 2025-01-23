package com.gestionprojet.pharmacie.dto;

import java.util.List;

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
    public static double getTotalCommission(List<CommissionDto> liste)
    {
        double total =0;
        for (int i=0; i < liste.size() ;i++) {
            total+=liste.get(i).getTotal();
        }
        return total;
    }
}
