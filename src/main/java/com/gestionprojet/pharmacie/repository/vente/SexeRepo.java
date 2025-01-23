package com.gestionprojet.pharmacie.repository.vente;

import com.gestionprojet.pharmacie.entity.vente.Sexe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SexeRepo extends JpaRepository<Sexe ,Integer> {
}