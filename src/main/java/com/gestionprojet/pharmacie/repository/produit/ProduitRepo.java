package com.gestionprojet.pharmacie.repository.produit;

import com.gestionprojet.pharmacie.entity.produit.Produit;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository<Produit, Integer> {
    @Query("SELECT p.* FROM Produit p " +
       "JOIN Curation c ON p.id = c.idProduit " +
       "JOIN Maladie m ON c.idMaladie = m.id " +
       "WHERE m.id = :idMaladie AND c.id_categorie_age = :idCategorieAge")
List<Produit> getFiltreProducts(@Param("idMaladie") int idMaladie, @Param("idCategorieAge") int idCategorieAge);

}
