package com.gestionprojet.pharmacie.repository.vente;

import com.gestionprojet.pharmacie.entity.produit.Produit;
import com.gestionprojet.pharmacie.entity.vente.Vente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface VenteRepo extends JpaRepository<Vente, Integer> {
    @Query("SELECT p FROM vente v " +
       "JOIN Fabrication f ON f.id = v.fabrication.id " +
       "JOIN Produit p ON p.id = f.produit.id " +
       "WHERE p.categorieProduit = :idCategorieProduit AND p.categorieAge.id = :idCategorieAge")
List<Produit> getFiltreVente(@Param("idCategorieProduit") int idCategorieProduit, @Param("idCategorieAge") int idCategorieAge);
}
