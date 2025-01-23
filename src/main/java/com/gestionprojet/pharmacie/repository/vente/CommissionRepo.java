package com.gestionprojet.pharmacie.repository.vente;

import com.gestionprojet.pharmacie.dto.CommissionDto;
import com.gestionprojet.pharmacie.entity.vente.Commission;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface CommissionRepo extends JpaRepository<Commission, Integer> {
   @Query("SELECT new com.gestionprojet.pharmacie.dto.CommissionDto(c.vendeur.id,c.vendeur.nom, SUM(c.prixCommission)) " +
       "FROM Commission c " +
       "WHERE c.vente.daty >= :debut AND c.vente.daty <= :fin " +
       "GROUP BY c.vendeur.id,c.vendeur.nom")
List<CommissionDto> getFiltreCommission(@Param("debut") LocalDate debut, @Param("fin") LocalDate fin);

@Query("SELECT new com.gestionprojet.pharmacie.dto.CommissionDto(c.vendeur.id,c.vendeur.nom, SUM(c.prixCommission)) " +
       "FROM Commission c " +
       "GROUP BY c.vendeur.id,c.vendeur.nom")
List<CommissionDto> getCommission();

@Query("SELECT new com.gestionprojet.pharmacie.dto.CommissionDto(c.vendeur.id,c.vendeur.nom, SUM(c.prixCommission)) " +
       "FROM Commission c " +
       "WHERE c.vente.daty >= :debut AND c.vente.daty <= :fin " +
       "AND c.vendeur.sexe.id= :sexe " +
       " GROUP BY c.vendeur.id,c.vendeur.nom")
List<CommissionDto> getFiltreCommissionSexe(@Param("debut") LocalDate debut, @Param("fin") LocalDate fin, @Param("sexe") int sexe);

}