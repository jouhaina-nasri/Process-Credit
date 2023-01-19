package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientBanque {
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
