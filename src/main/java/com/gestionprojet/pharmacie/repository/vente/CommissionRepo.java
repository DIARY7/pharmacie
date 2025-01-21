package com.gestionprojet.pharmacie.repository.vente;

import com.gestionprojet.pharmacie.entity.vente.Commission;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface CommissionRepo extends JpaRepository<Commission, Integer> {
    @Query("SELECT c FROM Commission c " +
    "JOIN Vente v ON v.id = c.vente.id " +
    "WHERE v.daty >= :debut AND v.daty <= :fin")
 List<Commission> getFiltreCommission(@Param("debut") LocalDate debut, @Param("fin") LocalDate fin);
}