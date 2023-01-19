package com.banque.application.controller;

import com.banque.application.entity.Dossier;
import com.banque.application.service.DossierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dossier")
public class DossierController {
    @Autowired
    DossierService dossierService;

    @Operation(summary = "Get All dossiers",
            description = "Get All dossiers.")
    @RequestMapping(method = RequestMethod.GET)
    public List<Dossier> findAll(){
        return dossierService.findAll();
    }

    @Operation(summary = "Add dossier",
            description = "Add dossier.")

    @RequestMapping(method = RequestMethod.POST)
    public Dossier save(@RequestParam("cin") @Parameter(description = "CIN") long cin,
                     @RequestParam("montant") @Parameter(description = "Montant") double montant,
                     @RequestParam("duree") @Parameter(description = "Duree") int duree,
                     @RequestParam("tauxNominal") @Parameter(description = "Taux Nominal") double tauxNominal,
                     @RequestParam("reference") @Parameter(description = "reference") long reference) {
        return dossierService.save(cin, montant, duree, tauxNominal, reference);
    }

    @Operation(summary = "Get full info of one dossier",
            description = "Get full info of one dossier"
    )
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Dossier getOneDossier(@RequestParam(name = "id") @Parameter(description = "Reference") long reference) {
        return dossierService.findById(reference);
    }

    @Operation(summary = "Get by cin",
            description = "Get by cin"
    )
    @RequestMapping(value = "/getOneByCin", method = RequestMethod.POST)
    public Object getOneDossierByCin(@RequestParam(name = "cin") @Parameter(description = "CIN") long cin) {
        return dossierService.findByCin(cin);
    }
}
