package ca.cal.tp1.service.DTO;

import ca.cal.tp1.modele.Dvd;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class DvdDTO extends DocumentDTO{
    private String directeur;
    private int duree;
    private String genre;
    private final int dureeEmpruntSem = 1;
    public DvdDTO (String titre, LocalDate anneePublication, String directeur, int duree, String genre) {
        super(titre, anneePublication);
        this.directeur = directeur;
        this.duree = duree;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "DvdDTO{" +
                ", titre='" + getTitre() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                "directeur='" + directeur + '\'' +
                ", duree=" + duree +
                ", genre='" + genre + '\'' +
                ", dureeEmpruntSem=" + dureeEmpruntSem +
                '}';
    }
    public DvdDTO toDTO(Dvd dvd){
        return new DvdDTO(dvd.getTitre(), dvd.getAnneePublication(), dvd.getDirecteur(), dvd.getDuree(), dvd.getGenre());
    }
}
