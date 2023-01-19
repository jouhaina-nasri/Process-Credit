package pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DossierCredit {
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

    public DossierCredit(double montantCredit, double interet, int duree, double mensualite, Long client_id, Long bareme_id) {
        this.montantCredit = montantCredit;
        this.interet = interet;
        this.duree = duree;
        this.mensualite = mensualite;
        this.client_id = client_id;
        this.bareme_id = bareme_id;
    }
}
