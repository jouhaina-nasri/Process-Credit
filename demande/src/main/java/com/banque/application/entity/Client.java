package com.banque.application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @Column(name = "cin", nullable = false)
    private long cin;
    private String nom;
    private String prenom;
    private double salaire;
    private TypeContrat type;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateNaiss;

}
