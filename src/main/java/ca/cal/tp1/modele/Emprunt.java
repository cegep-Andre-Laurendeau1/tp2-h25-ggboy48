package ca.cal.tp1.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Emprunt {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dateEmprunt;
    private String status;
    @ManyToOne
    private  Emprunteur emprunteur;
    @OneToMany
    private List<EmpruntDetails> empruntDetails;

    public Emprunt(LocalDate dateEmprunt, String status, List<EmpruntDetails> empruntDetails, Emprunteur emprunteur) {
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.empruntDetails = empruntDetails;
        this.emprunteur = emprunteur;
    }
    public Emprunt(LocalDate dateEmprunt, String status, Emprunteur emprunteur) {
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.emprunteur = emprunteur;
    }
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateEmprunt=" + dateEmprunt +
                ", status='" + status + '\'' +
                '}';
    }
}