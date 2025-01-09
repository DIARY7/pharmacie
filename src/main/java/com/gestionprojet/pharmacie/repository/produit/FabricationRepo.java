package com.gestionprojet.pharmacie.repository.produit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestionprojet.pharmacie.entity.produit.Fabrication;

@Repository
public interface FabricationRepo extends JpaRepository<Fabrication,Integer> {
    
}
