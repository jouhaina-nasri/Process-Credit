package com.banque.application.service;

import com.banque.application.entity.Decision;

import java.util.List;

public interface DecisionService {
    void save(Decision decision);
    List<Decision> findAll();

    Decision getOne(Long reference);
}
