package ca.cal.tp1.modele;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Cd extends Document{
    private String director;
    private int duree;
    private String genre;
    private final int dureeEmpruntSem = 2;

    public void savePreparedStatement (PreparedStatement ps) throws SQLException {
        ps.setString(5, director);
        ps.setInt(6, duree);
        ps.setString(7, genre);
    }

    public Cd(long id, String titre, LocalDate anneePublication, int nombreExemplaire, String director, int duree, String genre) {
        super(id, titre, anneePublication, nombreExemplaire);
        this.director = director;
        this.duree = duree;
        this.genre = genre;
    }

    public int getDuree() {
        return duree;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getDureeEmpruntSem() {
        return dureeEmpruntSem;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", nombreExemplaire=" + getNombreExemplaire() +
                "director='" + director + '\'' +
                ", duree=" + duree +
                ", genre='" + genre + '\'' +
                ", dureeEmpruntSem=" + dureeEmpruntSem +
                '}';
    }
}
