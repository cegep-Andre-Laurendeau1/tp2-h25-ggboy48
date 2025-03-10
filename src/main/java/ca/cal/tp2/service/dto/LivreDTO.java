package ca.cal.tp2.service.dto;

import lombok.*;


@Getter
@Setter



public class LivreDTO extends DocumentDTO {
    private String ISBN;

    private String editeur;

    private int nbPages;

    public LivreDTO(Integer id, String titre, String auteur, int annePublication, int nbrInventaire , String ISBN, String editeur, int nbPages) {
        super(id,titre,auteur,annePublication,nbrInventaire);
        this.ISBN = ISBN;
        this.editeur = editeur;
        this.nbPages = nbPages;
    }

    @Override
    public String toString() {
        return "LivreDTO [Titre=" + getTitre() + ", Auteur=" + getAuteur() + ", Année=" + getAnneePublication() + ", ISBN=" + ISBN +
                " , editeur= " + editeur + ", nbPages= " + nbPages + "]";
    }




}
