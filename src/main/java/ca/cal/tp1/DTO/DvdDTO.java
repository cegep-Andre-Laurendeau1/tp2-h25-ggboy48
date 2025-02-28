package ca.cal.tp1.DTO;

import ca.cal.tp1.modele.Dvd;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DvdDTO extends DocumentDTO {
    private String directeur;
    private int duree;
    private String genre;
    private final int dureeEmpruntSem = 1;
    public DvdDTO(long id, String titre, LocalDate anneePublication, int nombreExemplaire, String directeur, int duree, String genre) {
        super(id, titre, anneePublication, nombreExemplaire);
        this.directeur = directeur;
        this.duree = duree;
        this.genre = genre;
    }

    public DvdDTO(Dvd dvd){
        super(dvd.getId(), dvd.getTitre(), dvd.getAnneePublication(), dvd.getNombreExemplaire());
        this.directeur = dvd.getDirecteur();
        this.duree = dvd.getDuree();
        this.genre = dvd.getGenre();
    }

    public String getDirecteur() {
        return directeur;
    }

    public int getDuree() {
        return duree;
    }

    public String getGenre() {
        return genre;
    }

    public int getDureeEmpruntSem() {
        return dureeEmpruntSem;
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", nombreExemplaire=" + getNombreExemplaire() +
                "artiste='" + directeur + '\'' +
                ", duree=" + duree +
                ", genre='" + genre + '\'' +
                ", dureeEmpruntSem=" + dureeEmpruntSem +
                '}';
    }
}
