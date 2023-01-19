package com.banque.application.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dossier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference", nullable = false)
    private Long reference;
    private double montantCredit;
    private double interet;
    private int duree;
    private double mensualite;
    @Column(unique=true)
    private long client_id;
    private long bareme_id;

    public Dossier(double montantCredit, double interet, int duree, double mensualite, Long client_id, Long bareme_id) {
        this.montantCredit = montantCredit;
        this.interet = interet;
        this.duree = duree;
        this.mensualite = mensualite;
        this.client_id = client_id;
        this.bareme_id = bareme_id;
    }
}
