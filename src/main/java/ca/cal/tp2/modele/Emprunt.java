package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Getter
@Table (name="Emprunts")
@NoArgsConstructor
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dateEmprunt;

    @ManyToOne
    @JoinColumn(name="id_emprunteur")
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.PERSIST)
    private Set<EmpruntDocument> empruntsDocuments;

    public Emprunt(long id, LocalDate dateEmprunt, Emprunteur emprunteur) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.emprunteur = emprunteur;
    }

    public void ajouterEmpruntDetail(EmpruntDocument empruntDocument) {
        this.empruntsDocuments.add(empruntDocument);
    }
}
