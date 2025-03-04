package ca.cal.tp1.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
public class Cd extends Document{
    @Id
    @GeneratedValue
    private Long id;
    private String artiste;
    private int duree;
    private String genre;
    private final int dureeEmpruntSem = 2;

    public Cd(String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        super(titre, anneePublication, nombreExemplaire);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    public Cd(long id, String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        super(titre, anneePublication, nombreExemplaire);
        this.id = id;
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
