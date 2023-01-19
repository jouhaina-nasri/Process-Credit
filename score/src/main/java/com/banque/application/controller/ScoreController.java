package com.banque.application.controller;


import com.banque.application.entity.EvaluationScore;
import com.banque.application.entity.Score;
import com.banque.application.service.ScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import pojo.ClientBanque;
import pojo.DossierCredit;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @Operation(summary = "Evaluation Scores",
            description = "Evaluation Scores.")
    @RequestMapping(value = "/evaluation", method = RequestMethod.POST)
    public Score evaluation(@RequestParam("cin") @Parameter(description = "CIN") long cin) {
        Score op = new Score();
        try {
            URL oracle = new URL("http://localhost:8084/client/getOne?idClient=" + cin);
            URLConnection yc = oracle.openConnection();
            yc.setDoOutput(true);
            ((HttpURLConnection) yc).setRequestMethod("POST");
            yc.setRequestProperty("Content-Type", "application/json");
            OutputStream os = yc.getOutputStream();
            os.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;
            String outputJson = "";
            while ((inputLine = in.readLine()) != null) {
                outputJson = inputLine;
            }
            in.close();

            URL oracle1 = new URL("http://localhost:8084/dossier/getOneByCin?cin=" + cin);
            URLConnection yc1 = oracle1.openConnection();
            yc1.setDoOutput(true);
            ((HttpURLConnection) yc1).setRequestMethod("POST");
            yc1.setRequestProperty("Content-Type", "application/json");
            OutputStream os1 = yc1.getOutputStream();
            os1.flush();
            BufferedReader in1 = new BufferedReader(new InputStreamReader(
                    yc1.getInputStream()));
            String inputLine1;
            String outputJson1 = "";
            while ((inputLine1 = in1.readLine()) != null) {
                outputJson1 = inputLine1;
            }
            in1.close();
            Gson g = new Gson();
            Gson g1 = new Gson();
            if(!outputJson.isEmpty() && !outputJson1.isEmpty())
            {
                ClientBanque result = g.fromJson(outputJson, ClientBanque.class);
                DossierCredit result1 = g1.fromJson(outputJson1, DossierCredit.class);
                double score = scoreService.calcul(result,result1);
                op.setReference(result1.getReference());
                op.setScoreCalculee(score);
            }
            else
            {
                op.setScoreCalculee(0);
            }
            if(op.getScoreCalculee()<50) {op.setEvaluation(EvaluationScore.valueOf("Rouge"));}
            else {op.setEvaluation(EvaluationScore.valueOf("Vert"));}
            scoreService.save(op);
            URL oracle2 = new URL("http://localhost:8090/decision?reference="+op.getReference()+"&evaluation="+op.getEvaluation());
            URLConnection yc2 = oracle2.openConnection();
            yc2.setDoOutput(true);
            ((HttpURLConnection) yc2).setRequestMethod("POST");
            yc2.setRequestProperty("Content-Type", "application/json");
            OutputStream os2 = yc2.getOutputStream();
            os2.flush();
            BufferedReader in2 = new BufferedReader(new InputStreamReader(
                    yc2.getInputStream()));
            String inputLine2;
            String outputJson2 = "";
            while ((inputLine2 = in2.readLine()) != null) {
                outputJson2 = inputLine2;
            }
            in2.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(op);
        return op;
    }

    @Operation(summary = "Get full info of one score",
            description = "Get full info of one score"
    )
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Score getOne(@RequestParam(name = "id") @Parameter(description = "Reference") long reference) {
        return scoreService.findById(reference);
    }

    @Operation(summary = "Get All scores",
            description = "Get All scores.")
    @RequestMapping(method = RequestMethod.GET)
    public List<Score> findAll(){
        return scoreService.findAll();
    }
}