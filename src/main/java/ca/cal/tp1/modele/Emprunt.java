package ca.cal.tp1.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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

}