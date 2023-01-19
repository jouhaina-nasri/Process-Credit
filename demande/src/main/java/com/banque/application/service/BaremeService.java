package com.banque.application.service;

import com.banque.application.entity.Bareme;

import java.util.List;

public interface BaremeService {

    Bareme passerDemande(Double montant, int duree);
    void save(Bareme bareme);
    List<Bareme> findAll();
    Bareme findById(Long reference);

    Bareme tauxMinimum(List<Bareme> baremes);
}
