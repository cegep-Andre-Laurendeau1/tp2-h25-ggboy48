package ca.cal.tp1.service.DTO;

import ca.cal.tp1.modele.Livre;

import java.time.LocalDate;

public class LivreDTO extends DocumentDTO{
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;
    private final int dureeEmpruntSem = 3;
    public LivreDTO (String titre, LocalDate anneePublication, String ISBN, String auteur, String editeur, int nombrePages) {
        super(titre, anneePublication);
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
    }

    @Override
    public String toString() {
        return "LivreDTO{" +
                ", titre='" + getTitre() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                "ISBN='" + ISBN + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", nombrePages=" + nombrePages +
                ", dureeEmpruntSem=" + dureeEmpruntSem +
                '}';
    }
    public LivreDTO toDTO(Livre livre){
        return new LivreDTO(livre.getTitre(), livre.getAnneePublication(), livre.getISBN(), livre.getAuteur(), livre.getEditeur(), livre.getNombrePages());
    }
}
