package com.banque.application.service;

import com.banque.application.entity.Dossier;

import java.util.List;

public interface DossierService {

    double calculInteret(double montant, double taux);
    double calculMensualite(double montant,double interet,int duree);
    Dossier save(long cin,double montant,int duree,double tauxNominal,long reference);
    List<Dossier> findAll();
    Dossier findById(long reference);
    Object findByCin(long cin);
}
