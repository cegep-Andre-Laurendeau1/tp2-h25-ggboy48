package ca.cal.tp1.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Livre extends Document {
    @Id
    @GeneratedValue
    private Long id;

    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;
    private final int dureeEmpruntSem = 3;

    public Livre( String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        super(titre, anneePublication, nombreExemplaire);
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
    }
    public Livre(Long id, String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        super(titre, anneePublication, nombreExemplaire);
        this.id = id;
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
