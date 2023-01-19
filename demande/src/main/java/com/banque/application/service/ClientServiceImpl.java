package com.banque.application.service;

import com.banque.application.entity.Client;
import com.banque.application.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;
    @Override
    public void save(Client client) {
            clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long cin) {
        return clientRepository.findById(cin).orElse(null);
    }

    @Override
    public boolean findExistance(Client client) {
        Client c = clientRepository.findById(client.getCin()).orElse(null);
        if(c==null)
        {
            return false;
        }
        else return true;
    }
}
