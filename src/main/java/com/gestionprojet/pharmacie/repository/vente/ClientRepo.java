package com.gestionprojet.pharmacie.repository.vente;

import com.gestionprojet.pharmacie.entity.vente.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepo extends JpaRepository<Client, Integer> {
}
