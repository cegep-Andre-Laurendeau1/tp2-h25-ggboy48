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
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Amende {
    @Id
    @GeneratedValue
    private Long id;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;

    @ManyToOne
    private Emprunteur emprunteur;
}