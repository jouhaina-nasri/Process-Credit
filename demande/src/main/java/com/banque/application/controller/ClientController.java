package com.banque.application.controller;

import com.banque.application.entity.Client;
import com.banque.application.entity.TypeContrat;
import com.banque.application.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @Operation(summary = "Get All clients",
            description = "Get All clients.")
    @RequestMapping(method = RequestMethod.GET)
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @Operation(summary = "Add client",
            description = "Add client.")

    @RequestMapping(method = RequestMethod.POST)
    public Client save(@RequestParam("cin") @Parameter(description = "CIN") long cin,
                     @RequestParam("nom") @Parameter(description = "Nom") String nom,
                     @RequestParam("prenom") @Parameter(description = "Prenom") String prenom,
                     @RequestParam("salaire") @Parameter(description = "Salaire") double salaire,
                     @RequestParam("type") @Parameter(description = "Type de contrat")TypeContrat typeContrat,
                     @RequestParam("dateNaiss") @Parameter(description = "Date de naissance yyyy-mm-dd")
                         @DateTimeFormat(pattern="yyyy-MM-dd")Date date) {
        Client client = new Client(cin,nom,prenom,salaire,typeContrat,date);
        clientService.save(client);
        return client;
    }

    @Operation(summary = "Get full info of one client",
            description = "Get full info of one client"
    )
    @RequestMapping(value = "/getOne", method = RequestMethod.POST)
    public Client getOneClient(@RequestParam(name = "idClient") long id) {
        return clientService.findById(id);
    }

    @Operation(summary = "Test existence du client",
            description = "Test existence du client"
    )
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public boolean verifyExistence(@RequestParam("cin") @Parameter(description = "CIN") long cin,
                                   @RequestParam("nom") @Parameter(description = "Nom") String nom,
                                   @RequestParam("prenom") @Parameter(description = "Prenom") String prenom,
                                   @RequestParam("salaire") @Parameter(description = "Salaire") double salaire,
                                   @RequestParam("type") @Parameter(description = "Type de contrat")TypeContrat typeContrat,
                                   @RequestParam("dateNaiss") @Parameter(description = "Date de naissance yyyy-mm-dd")
                                       @DateTimeFormat(pattern="yyyy-MM-dd")Date date) {
        Client client = new Client(cin,nom,prenom,salaire,typeContrat,date);
        return clientService.findExistance(client);
    }

}
