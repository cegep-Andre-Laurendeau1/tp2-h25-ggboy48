package ca.cal.tp2.modele;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Getter
@Table(name="CD")

public class CD extends Document  {
    private String artiste;
    private int duree;
    private String genre;
    private int dureeEmprunt = 14;

    @Override
    public int getDureeEmprunt() {
        return dureeEmprunt;
    }


    public CD(Integer id, String titre, String auteur, int anneePublication,  int nbrInventaire,
              String artiste, int duree, String genre) {
        super(id,titre,auteur,anneePublication,nbrInventaire);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }




}
