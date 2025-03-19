package ca.cal.tp1.service.DTO;

import ca.cal.tp1.modele.Cd;

import java.time.LocalDate;

public class CdDTO extends DocumentDTO {
    private String artiste;
    private int duree;
    private String genre;
    private final int dureeEmpruntSem = 2;

    public CdDTO (String titre, LocalDate anneePublication,  String artiste, int duree, String genre) {
        super(titre, anneePublication);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "CdDTO{" +
                ", titre='" + getTitre() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                "artiste='" + artiste + '\'' +
                ", duree=" + duree +
                ", genre='" + genre + '\'' +
                ", dureeEmpruntSem=" + dureeEmpruntSem +
                '}';
    }
    public CdDTO toDTO(Cd cd){
        return new CdDTO(cd.getTitre(), cd.getAnneePublication(), cd.getArtiste(), cd.getDuree(), cd.getGenre());
    }
}