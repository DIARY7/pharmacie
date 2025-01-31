package com.gestionprojet.pharmacie.repository.vente;

import com.gestionprojet.pharmacie.entity.vente.Vente;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface VenteRepo extends JpaRepository<Vente, Integer> {
    @Query("SELECT v FROM Vente v " +
       " WHERE v.livraison.fabrication.produit.categorieProduit.id = :idCategorieProduit AND v.livraison.fabrication.produit.categorieAge.id = :idCategorieAge")
    List<Vente> getFiltreVente(@Param("idCategorieProduit") int idCategorieProduit, @Param("idCategorieAge") int idCategorieAge);

    @Query("SELECT v FROM Vente v " +
       "WHERE v.daty = :date")
    List<Vente> getVenteAndroany(@Param("date") LocalDate date);
}
