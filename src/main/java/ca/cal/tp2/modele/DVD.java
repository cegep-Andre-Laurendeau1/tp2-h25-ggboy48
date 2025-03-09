package ca.cal.tp2.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DVD") // Hibernate va créer une table "Livre"
@Data
@NoArgsConstructor


public class DVD extends Document {
    private String directeur;
    private int duree;
    private String rating;


    public DVD(int id, String titre, String auteur, int anneePublication, int dureeEmprunt, int nbrInventaire,
              String directeur, int duree, String rating) {
        super(id,titre,auteur,anneePublication,dureeEmprunt,nbrInventaire);
        this.directeur = directeur;
        this.duree = duree;
        this.rating = rating;
    }

}
