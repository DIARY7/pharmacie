package com.gestionprojet.pharmacie.repository.produit;

import com.gestionprojet.pharmacie.entity.produit.Produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository<Produit, Integer> {
}
