package com.gestionprojet.pharmacie.service.vente;

import org.springframework.stereotype.Service;

import com.gestionprojet.pharmacie.entity.produit.Fabrication;

@Service
public class VenteService {

    public double calculeCommission(Fabrication fabrication){
        double commission = (fabrication.getPrix()*5)/100;
        return commission;
    }    
}
