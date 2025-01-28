package com.gestionprojet.pharmacie.service.vente;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionprojet.pharmacie.entity.Livraison;
import com.gestionprojet.pharmacie.entity.produit.Fabrication;
import com.gestionprojet.pharmacie.repository.LivraisonRepo;

@Service
public class VenteService {

    @Autowired
    LivraisonRepo livraisonRepo;

    public double calculeCommission(Livraison livraison,double nombre){
        double vidiny = livraison.getPrixUnitaire() *nombre;
        double commission = 0;
        if (vidiny >= 200000) {
            commission = ((vidiny) *5)/100;
        } 
        return commission;
    }   

    public Livraison getLivraison(LocalDate date_vente,int id_fabrication) {
        return livraisonRepo.getLivraisonfarany(date_vente,id_fabrication);
    }
}
