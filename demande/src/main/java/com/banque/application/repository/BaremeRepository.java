package com.banque.application.repository;

import com.banque.application.entity.Bareme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaremeRepository extends JpaRepository<Bareme, Long> {

    @Query("select u from Bareme u where u.montantMin <= ?1 and u.montantMax>= ?1 and u.dureeMin <= ?2 and u.dureeMax >= ?2")
    List<Bareme> findBareme(double montant, int duree);
}
