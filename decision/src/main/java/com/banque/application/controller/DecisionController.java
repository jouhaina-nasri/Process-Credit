package com.banque.application.controller;

import com.banque.application.entity.Decision;
import com.banque.application.entity.Status;
import com.banque.application.service.DecisionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.EvaluationScore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/decision")
public class DecisionController {
    @Autowired
    DecisionService decisionService;

    @Operation(summary = "Get All decisions",
            description = "Get All decisions.")
    @RequestMapping(method = RequestMethod.GET)
    public List<Decision> findAll(){
        return decisionService.findAll();
    }

    @Operation(summary = "Add decision",
            description = "Add decision.")

    @RequestMapping(method = RequestMethod.POST)
    public Decision save(@RequestParam(name = "reference",required = false,defaultValue = "0") @Parameter(description = "reference") Long reference,
                     @RequestParam("evaluation") @Parameter(description = "evaluation") EvaluationScore evaluation){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateDecision = new Date();
        Decision decision = new Decision();
        decision.setDateDecision(dateDecision);
        decision.setReference(reference);
        if (evaluation.name().equals("Vert"))
        {
            decision.setStatusDecision(Status.valueOf("Acceptation"));
        }
        else
        {
            decision.setStatusDecision(Status.valueOf("Refus"));
        }
        decisionService.save(decision);
        return decision;
    }


    @Operation(summary = "Get full info of one decision",
            description = "Get full info of one decision"
    )
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Decision getOne(@RequestParam(name = "reference") @Parameter(description = "Reference") long reference) {
        return decisionService.getOne(reference);
    }
}
