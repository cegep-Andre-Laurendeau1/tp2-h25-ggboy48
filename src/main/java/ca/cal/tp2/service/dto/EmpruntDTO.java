package ca.cal.tp2.service.dto;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString

public class EmpruntDTO {

    private Integer id;

    private LocalDate dateEmprunt;

    private EmprunteurDTO emprunteur;

    private String status;

    private List<EmpruntDetailDTO> empruntsDocuments;

    // Constructeur
    public EmpruntDTO(Integer id, LocalDate dateEmprunt, String status, EmprunteurDTO emprunteur, List<EmpruntDetailDTO> empruntsDocuments) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.emprunteur = emprunteur;
        this.empruntsDocuments = empruntsDocuments;
    }


    public void addEmpruntDetail(EmpruntDetailDTO empruntDetailDTO) {
        this.empruntsDocuments.add(empruntDetailDTO);
    }


    @Override
    public String toString() {
        return "EmpruntDTO{" +
                "id=" + id +
                ", dateEmprunt=" + dateEmprunt +
                ", status='" + status + '\'' +
                ", emprunteur=" + (emprunteur != null ? emprunteur.toString() : "null") +
                ", empruntsDocuments=" + (empruntsDocuments != null ? empruntsDocuments.toString() : "null") +
                '}';
    }




}
