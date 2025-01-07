package com.gestionprojet.pharmacie.repository.maladie;
import com.gestionprojet.pharmacie.entity.maladie.Curration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CurrationRepo extends JpaRepository<Curration, Integer> {
}