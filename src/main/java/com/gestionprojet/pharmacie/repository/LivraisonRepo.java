package com.gestionprojet.pharmacie.repository;
import com.gestionprojet.pharmacie.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LivraisonRepo extends JpaRepository<Livraison, Integer> {
}
