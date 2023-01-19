package com.banque.application.service;


import com.banque.application.entity.Score;
import com.banque.application.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.ClientBanque;
import pojo.DossierCredit;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    ScoreRepository scoreRepository;
    @Override
    public void save(Score score) {
        scoreRepository.save(score);
    }

    @Override
    public List<Score> findAll() {
        return scoreRepository.findAll();
    }

    @Override
    public Score findById(Long reference) {
        return scoreRepository.findById(reference).orElse(null);
    }

    @Override
    public double calcul(ClientBanque client, DossierCredit dossier) {
        double score = 0;
        if (client.getSalaire() > 2000) { score = score + 20;}
        else if ((client.getSalaire() > 1000) && (client.getSalaire() < 2000)){ score = score + 10;}
        if (client.getType().name().equals("CDI")){ score = score + 30;}
        double mensualite=dossier.getMensualite() / client.getSalaire();
        if ( mensualite< 0.45) { score = score + 50;}
        return score;
    }
}
