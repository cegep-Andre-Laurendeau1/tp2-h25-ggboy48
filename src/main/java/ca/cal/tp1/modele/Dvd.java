package ca.cal.tp1.modele;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Dvd extends Document{
    private String directeur;
    private int duree;
    private String genre;
    private final int dureeEmpruntSem = 1;

    public Dvd(long id, String titre, LocalDate anneePublication, int nombreExemplaire, String directeur, int duree, String genre) {
        super(id, titre, anneePublication, nombreExemplaire);
        this.directeur = directeur;
        this.duree = duree;
        this.genre = genre;
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
                "directeur='" + directeur + '\'' +
                ", duree=" + duree +
                ", genre='" + genre + '\'' +
                ", dureeEmpruntSem=" + dureeEmpruntSem +
                '}';
    }
}
