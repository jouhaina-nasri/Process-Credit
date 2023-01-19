package com.banque.application.repository;

import com.banque.application.entity.Bareme;
import com.banque.application.entity.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DossierRepository extends JpaRepository<Dossier,Long> {
    @Query("select u from Dossier u where u.client_id = ?1")
    Dossier findByCin(long cin);
}
