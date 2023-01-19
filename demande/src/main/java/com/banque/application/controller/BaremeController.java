package com.banque.application.controller;

import com.banque.application.entity.Bareme;
import com.banque.application.service.BaremeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/bareme")
public class BaremeController {
    @Autowired
    BaremeService baremeService;

    @Operation(summary = "Get All baremes",
            description = "Get All baremes.")
    @RequestMapping(method = RequestMethod.GET)
    public List<Bareme> findAll(){
        return baremeService.findAll();
    }


    @Operation(summary = "Get All baremes demandeq",
            description = "Get All baremes.")
    @RequestMapping(value = "/demande", method = RequestMethod.GET)
    public Bareme passerDemande(@RequestParam("montant") @Parameter(description = "Montant") double montant,
                                      @RequestParam("duree") @Parameter(description = "Duree") int duree){
        return baremeService.passerDemande(montant,duree);
    }

    @Operation(summary = "Add bareme",
            description = "Add bareme.")

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestParam("tauxNominal") @Parameter(description = "Taux Nominal") double tauxNominal,
                     @RequestParam("dureeMin") @Parameter(description = "Duree Minimum") int dureeMin,
                     @RequestParam("dureeMax") @Parameter(description = "Duree Maximum") int dureeMax,
                     @RequestParam("montantMin") @Parameter(description = "Montant Minimum") double montantMin,
                     @RequestParam("montantMax") @Parameter(description = "Montant Maximum") double montantMax) {
        Bareme bareme = new Bareme(tauxNominal, dureeMin, dureeMax, montantMin, montantMax);
        baremeService.save(bareme);
    }

    @Operation(summary = "Get full info of one bareme",
            description = "Get full info of one bareme"
    )
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Bareme getOneBareme(@RequestParam(name = "id") @Parameter(description = "Reference") Long reference) {
        return baremeService.findById(reference);
    }
}
