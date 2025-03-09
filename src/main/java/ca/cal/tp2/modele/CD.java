package ca.cal.tp2.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CD") // Hibernate va créer une table "Livre"
@Data
@NoArgsConstructor


public class CD extends Document  {
    private String artiste;
    private int duree;
    private String genre;


    public CD(int id, String titre, String auteur, int anneePublication, int dureeEmprunt, int nbrInventaire,
              String artiste, int duree, String genre) {
        super(id,titre,auteur,anneePublication,dureeEmprunt,nbrInventaire);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }




}
