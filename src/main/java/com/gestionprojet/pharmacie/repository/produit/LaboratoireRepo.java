package com.gestionprojet.pharmacie.repository.produit;

import com.gestionprojet.pharmacie.entity.produit.Laboratoire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LaboratoireRepo extends JpaRepository<Laboratoire, Integer> {
}
