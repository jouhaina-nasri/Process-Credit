package com.banque.application.service;

import com.banque.application.entity.Score;
import pojo.ClientBanque;
import pojo.DossierCredit;

import java.util.List;

public interface ScoreService {
    void save(Score score);
    List<Score> findAll();
    Score findById(Long reference);

    double calcul(ClientBanque client, DossierCredit dossier);

}
