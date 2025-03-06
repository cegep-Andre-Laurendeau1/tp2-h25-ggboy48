package ca.cal.tp1.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmpruntDetails {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;

    @ManyToOne
    private Emprunt emprunt;

    @ManyToOne
    private Document document;

    public EmpruntDetails(LocalDate dateRetourPrevue, LocalDate dateRetourActuelle, String status) {
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
    }
    public EmpruntDetails(LocalDate dateRetourPrevue, String status, Emprunt emprunt, Document document) {
        this.dateRetourPrevue = dateRetourPrevue;
        this.status = status;
        this.emprunt = emprunt;
        this.document = document;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public LocalDate getDateRetourActuelle() {
        return dateRetourActuelle;
    }

    public String getStatus() {
        return status;
    }
}
