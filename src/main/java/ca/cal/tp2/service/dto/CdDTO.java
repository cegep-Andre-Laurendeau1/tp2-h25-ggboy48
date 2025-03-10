package ca.cal.tp2.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.print.Doc;

@Getter
@Setter
public class CdDTO extends DocumentDTO {
    private String artiste;
    private int duree;
    private String genre;

    public CdDTO(Integer id, String titre, String auteur, int anneePublication, int nbrInventaire, String artiste, int duree, String genre) {
        super(id, titre , auteur, anneePublication, nbrInventaire);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "CdDTO [Titre=" + getTitre() + ", Auteur=" + getAuteur() + ", Année=" + getAnneePublication() + ", artiste=" + artiste +
                " , duree= " + duree + ", genre= " + genre + "]";
    }
}
