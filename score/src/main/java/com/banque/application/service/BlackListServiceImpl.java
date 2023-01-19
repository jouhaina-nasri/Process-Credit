package com.banque.application.service;

import com.banque.application.blacklist.repository.BlackListRepository;
import com.banque.application.entity.blacklist.BlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListServiceImpl implements BlackListService{

    @Autowired
    BlackListRepository blackListRepository;
    @Override
    public List<BlackList> findAll() {
        return blackListRepository.findAll();
    }

    @Override
    public BlackList findByCin(Long cin) {
        return blackListRepository.findByCin(cin);
    }
}
