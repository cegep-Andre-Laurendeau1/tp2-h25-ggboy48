package ca.cal.tp2.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpruntDetailDTO {
    private String titreDocument;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;



    public EmpruntDetailDTO(String titreDocument, LocalDate dateRetourPrevue, LocalDate dateRetourActuelle, String status) {
        this.titreDocument = titreDocument;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
    }


    @Override
    public String toString() {
        return "EmpruntDetailDTO{" +
                "titreDocument='" + titreDocument + '\'' +
                ", dateRetourPrevue=" + (dateRetourPrevue != null ? dateRetourPrevue.toString() : "N/A") +
                ", dateRetourActuelle=" + (dateRetourActuelle != null ? dateRetourActuelle.toString() : "N/A") +
                ", status='" + (status != null ? status : "N/A") + '\'' +
                '}';
    }
}
