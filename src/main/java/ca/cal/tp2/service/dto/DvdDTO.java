package ca.cal.tp2.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DvdDTO extends DocumentDTO {
    private String directeur;
    private int duree;
    private String rating;

    public DvdDTO(Integer id , String titre, String auteur, int anneePublication,int nbrInventaire, String directeur, int duree, String rating) {
        super(id, titre, auteur, anneePublication, nbrInventaire);
        this.directeur = directeur;
        this.duree = duree;
        this.rating = rating;
    }

}
