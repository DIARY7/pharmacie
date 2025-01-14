package com.gestionprojet.pharmacie.repository.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionprojet.pharmacie.entity.produit.Fabrication;

@Repository
public interface FabricationRepo extends JpaRepository<Fabrication,Integer> {
    
}
