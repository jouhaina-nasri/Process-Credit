package com.banque.application.service;

import com.banque.application.entity.Bareme;
import com.banque.application.repository.BaremeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaremeServiceImpl implements BaremeService{

    @Autowired
    BaremeRepository baremeRepository;

    @Override
    public Bareme passerDemande(Double montant, int duree) {
    List<Bareme> baremes = baremeRepository.findBareme(montant,duree);
    System.out.println(baremes);
    Bareme bareme = new Bareme();
    if(baremes!=null){
         bareme=this.tauxMinimum(baremes);
    }
    return bareme;
    }

    @Override
    public void save(Bareme bareme) {
        Bareme b = baremeRepository.findById(bareme.getReference()).orElse(null);
        if (b!=null)
        {
            throw new Error("Le bareme existe déja");
        }
        else
        {
            baremeRepository.save(bareme);
        }
    }

    @Override
    public List<Bareme> findAll() {
        return baremeRepository.findAll();
    }

    @Override
    public Bareme findById(Long reference) {
        return baremeRepository.findById(reference).orElse(null);
    }

    @Override
    public Bareme tauxMinimum(List<Bareme> baremes) {
        Bareme minimum = baremes.get(0);
        for (int i=1;i<baremes.size();i++){
            if(minimum.getTauxNominal()>baremes.get(i).getTauxNominal())
            {
                minimum=baremes.get(i);
            }
        }
        return minimum;
    }
}
