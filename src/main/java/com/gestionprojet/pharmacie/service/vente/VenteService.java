package com.gestionprojet.pharmacie.service.vente;

import org.springframework.stereotype.Service;

import com.gestionprojet.pharmacie.entity.produit.Fabrication;

@Service
public class VenteService {

    public double calculeCommission(Fabrication fabrication,double nombre){
        double vidiny = fabrication.getPrix() *nombre;
        double commission = 0;
        if (vidiny >= 200000) {
            commission = ((vidiny) *5)/100;
        } 
        return commission;
    }    
}
