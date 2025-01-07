package com.gestionprojet.pharmacie.repository.produit;

import com.gestionprojet.pharmacie.entity.produit.Produit;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository<Produit, Integer> {
    @Query("SELECT p FROM Produit p " +
       "JOIN Curration c ON p.id = c.produit.id " +
       "JOIN Maladie m ON c.maladie.id = m.id " +
       "WHERE m.id = :idMaladie AND p.categorieAge.id = :idCategorieAge")
List<Produit> getFiltreProducts(@Param("idMaladie") int idMaladie, @Param("idCategorieAge") int idCategorieAge);

}
