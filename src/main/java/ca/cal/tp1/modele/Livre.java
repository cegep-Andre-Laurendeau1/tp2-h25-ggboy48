package ca.cal.tp1.modele;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Livre extends Document {
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;
    private final int dureeEmpruntSem = 3;

    public Livre(long id, String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        super(id, titre, anneePublication, nombreExemplaire);
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public int getDureeEmpruntSem() {
        return dureeEmpruntSem;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", nombreExemplaire=" + getNombreExemplaire() +
                "ISBN='" + ISBN + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", nombrePages=" + nombrePages +
                ", dureeEmpruntSem=" + dureeEmpruntSem +
                '}';
    }
}
