package ca.cal.tp1.modele;

import java.time.LocalDate;


public class Cd extends Document{
    private String artiste;
    private int duree;
    private String genre;
    private final int dureeEmpruntSem = 2;

    public Cd(Long id, String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        super(id, titre, anneePublication, nombreExemplaire);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
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

    public String getArtiste() {
        return artiste;
    }

    @Override
    public String toString() {
        return "Cd{" +
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
