package com.gestionprojet.pharmacie.repository.produit;

import com.gestionprojet.pharmacie.entity.produit.Conseil;
import com.gestionprojet.pharmacie.entity.produit.Produit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface ConseilRepo extends JpaRepository<Conseil, Integer> {
    @Query("SELECT p FROM Produit p " +
       "JOIN Conseil c ON p.id = c.produit.id " +
       "WHERE c.mois = :mois AND c.annee = :annee")
List<Produit> getFiltreConseil(@Param("mois") int mois, @Param("annee") int annee);

@Query("SELECT p FROM Produit p " +
       "JOIN Conseil c ON p.id = c.produit.id " +
       "WHERE c.mois = :mois AND c.annee = :annee " +
       " AND c.produit.id= :produit")
List<Produit> checkInConseil(@Param("mois") int mois, @Param("annee") int annee,@Param("produit") int produit);

@Query("SELECT p FROM Produit p " +
"JOIN Conseil c ON p.id = c.produit.id " +
"WHERE c.annee = :annee")
List<Produit> getFiltreConseilannee( @Param("annee") int annee);

}
