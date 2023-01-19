package com.banque.application.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bareme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference", nullable = false)
    private long reference;
    private double tauxNominal;
    private int dureeMin;
    private int dureeMax;
    private double montantMin;
    private double montantMax;
    public Bareme(double tauxNominal, int dureeMin, int dureeMax, double montantMin, double montantMax) {
        this.tauxNominal = tauxNominal;
        this.dureeMin = dureeMin;
        this.dureeMax = dureeMax;
        this.montantMin = montantMin;
        this.montantMax = montantMax;
    }
}

