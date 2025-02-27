package ca.cal.tp1.modele;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Dvd extends Document{
    private String artiste;
    private int duree;
    private String genre;
    private final int dureeEmpruntSem = 1;

    @Override
    public void savePreparedStatement(PreparedStatement ps) throws SQLException {
        ps.setString(5, artiste);
        ps.setInt(6, duree);
        ps.setString(7, genre);
    }
    public Dvd(long id, String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        super(id, titre, anneePublication, nombreExemplaire);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    public String getArtiste() {
        return artiste;
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
                "artiste='" + artiste + '\'' +
                ", duree=" + duree +
                ", genre='" + genre + '\'' +
                ", dureeEmpruntSem=" + dureeEmpruntSem +
                '}';
    }
}
