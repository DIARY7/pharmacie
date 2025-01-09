package com.gestionprojet.pharmacie.repository.vente;

import com.gestionprojet.pharmacie.entity.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VenteRepo extends JpaRepository<Vente, Integer> {
}
