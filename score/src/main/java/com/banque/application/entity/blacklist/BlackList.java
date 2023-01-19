package com.banque.application.entity.blacklist;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BlackList")
public class BlackList implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cin", nullable = false)
    private long cin;
    private String nom;
    private String prenom;
    private double salaire;
    private TypeContrat type;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateNaiss;
}
