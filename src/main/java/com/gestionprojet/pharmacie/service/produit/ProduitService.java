package com.gestionprojet.pharmacie.service.produit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionprojet.pharmacie.entity.produit.Produit;
import com.gestionprojet.pharmacie.repository.produit.ConseilRepo;

@Service
public class ProduitService {
    @Autowired
    ConseilRepo conseilRepo;

    public void checkInConseil(int mois, int annee, int id_produit) throws Exception {
        List<Produit> listeProd = conseilRepo.checkInConseil(mois, annee, id_produit);
        if (listeProd.size()!=0) {
            throw new Exception("Ce produit est deja le conseil de ce mois");
        }
    }
}
