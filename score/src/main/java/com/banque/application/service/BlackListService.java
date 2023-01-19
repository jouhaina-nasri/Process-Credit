package com.banque.application.service;

import com.banque.application.entity.blacklist.BlackList;

import java.util.List;

public interface BlackListService {
    List<BlackList> findAll();
    BlackList findByCin(Long cin);
}
