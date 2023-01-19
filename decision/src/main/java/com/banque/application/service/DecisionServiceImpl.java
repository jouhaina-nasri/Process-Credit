package com.banque.application.service;

import com.banque.application.entity.Decision;
import com.banque.application.repository.DecisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecisionServiceImpl implements DecisionService{

    @Autowired
    DecisionRepository decisionRepository;
    @Override
    public void save(Decision decision) {
        decisionRepository.save(decision);
    }

    @Override
    public List<Decision> findAll() {
        return decisionRepository.findAll();
    }

    @Override
    public Decision getOne(Long reference) {
        return decisionRepository.findDecision(reference);
    }
}
