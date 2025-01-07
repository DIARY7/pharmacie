package com.gestionprojet.pharmacie.repository.maladie;
import com.gestionprojet.pharmacie.entity.maladie.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MaladieRepo extends JpaRepository<Maladie, Integer> {
}
