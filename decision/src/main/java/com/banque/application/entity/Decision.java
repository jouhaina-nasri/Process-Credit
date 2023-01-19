package com.banque.application.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private long reference;
    private Date dateDecision;
    private Status statusDecision;

    public Decision(long reference, Date dateDecision, Status statusDecision) {
        this.reference = reference;
        this.dateDecision = dateDecision;
        this.statusDecision = statusDecision;
    }
}
