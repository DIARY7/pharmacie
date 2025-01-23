package com.gestionprojet.pharmacie.service.produit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionprojet.pharmacie.entity.produit.Fabrication;
import com.gestionprojet.pharmacie.repository.produit.FabricationRepo;
import com.gestionprojet.pharmacie.repository.produit.ProduitRepo;

@Service
public class FabricationService {
    @Autowired
    FabricationRepo fabRepo;

    @Autowired
    ProduitRepo prodRepo;

    public void save(int id_produit,LocalDate dateFabrication,LocalDate datePeremption,double prix) throws Exception {
        Fabrication fabrication = new Fabrication(dateFabrication, datePeremption);
        fabrication.setPrix(prix);
        fabrication.setProduit(prodRepo.findById(id_produit).orElseThrow(()->new Exception("Produit innexistant")));
        fabRepo.save(fabrication);
    }

    public List<Fabrication> getAll(){
        return fabRepo.findAll();
    }
}
