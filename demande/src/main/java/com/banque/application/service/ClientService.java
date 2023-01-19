package com.banque.application.service;

import com.banque.application.entity.Client;

import java.util.List;

public interface ClientService {

    void save(Client client);
    List<Client> findAll();
    Client findById(Long cin);
    boolean findExistance(Client client);
}
