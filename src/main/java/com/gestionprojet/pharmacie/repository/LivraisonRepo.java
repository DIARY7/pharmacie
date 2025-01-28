package com.gestionprojet.pharmacie.repository;
import com.gestionprojet.pharmacie.entity.Livraison;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface LivraisonRepo extends JpaRepository<Livraison, Integer> {
    @Query("SELECT l FROM livraison l " +
       "JOIN fabrication f ON f.id=l.fabrication.id "+
       "WHERE f.id = :id AND l.daty <= :date"+
       "ORDER BY l.daty DESC LIMIT 1")
    Livraison getLivraisonfarany(@Param("date") LocalDate date, @Param("id") int id);

    @Query("SELECT l FROM livraison l " +
       "WHERE l.daty >= :datedebut AND l.daty <= :datefin")
    List<Livraison> getLivraisonfiltre(@Param("date") LocalDate datedebut, @Param("date") LocalDate datefin);
}
