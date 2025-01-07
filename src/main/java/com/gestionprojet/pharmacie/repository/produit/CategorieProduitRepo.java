package com.gestionprojet.pharmacie.repository.produit;

import com.gestionprojet.pharmacie.entity.produit.CategorieProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategorieProduitRepo extends JpaRepository<CategorieProduit, Integer> {
}
