package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="DVD")


public class DVD extends Document {
    private String directeur;
    private int duree;
    private String rating;
    private int dureeSemaineEmprunt=1;


    public DVD(Integer id, String titre, String auteur, int anneePublication, int nbrInventaire,
              String directeur, int duree, String rating) {
        super(id,titre,auteur,anneePublication,nbrInventaire);
        this.directeur = directeur;
        this.duree = duree;
        this.rating = rating;
    }

}
