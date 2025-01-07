package com.gestionprojet.pharmacie.repository.produit;


import com.gestionprojet.pharmacie.entity.produit.TypeProduit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProduitRepo extends JpaRepository<TypeProduit,Integer> {
    
}
