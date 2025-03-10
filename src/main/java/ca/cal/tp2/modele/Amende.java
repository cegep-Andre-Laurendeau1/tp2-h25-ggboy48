package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table
@Data
@NoArgsConstructor
@Getter
public class Amende {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAmende;
    private double montant;

    @Setter
    private LocalDate dateCreation;

    @Setter
    private boolean status;

    @ManyToOne
    @JoinColumn(name="id_emprunteur")
    private Emprunteur emprunteur;

    public Amende(int idAmende, double montant, LocalDate dateCreation, boolean status) {
        this.idAmende = idAmende;
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.status = status;
    }



}

