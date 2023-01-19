package com.banque.application.service;

import com.banque.application.entity.Bareme;
import com.banque.application.entity.Dossier;
import com.banque.application.repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierServiceImpl implements DossierService{

    @Autowired
    DossierRepository dossierRepository;
    @Autowired
    BaremeService baremeService;
    @Override
    public double calculInteret(double montant, double taux) {
        return montant*taux;
    }

    @Override
    public double calculMensualite(double montant, double interet, int duree) {
        return (montant+interet)/duree;
    }

    @Override
    public Dossier save(long cin, double montant, int duree, double tauxNominal,long reference) {
            double interet = calculInteret(montant, tauxNominal);
            double mensualite = calculMensualite(montant,interet, duree);
            Dossier dossier = new Dossier(montant, interet,  duree,  mensualite, cin, reference);
            dossierRepository.save(dossier);
            return dossier;
    }

    @Override
    public List<Dossier> findAll() {
        return dossierRepository.findAll();
    }

    @Override
    public Object findByCin(long cin) {
         Dossier dossier = dossierRepository.findByCin(cin);
         if (dossier==null)
             return false;
         else
             return dossier;
    }

    @Override
    public Dossier findById(long reference) {
        return dossierRepository.findById(reference).orElse(null);
    }
}
