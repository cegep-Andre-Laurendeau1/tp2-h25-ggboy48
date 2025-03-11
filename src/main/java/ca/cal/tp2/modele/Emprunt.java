package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Getter
@Table (name="Emprunts")
@NoArgsConstructor
public class Emprunt {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateEmprunt;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id_emprunteur", nullable = false)
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private Set<EmpruntDetail> empruntsDocuments;

    public Emprunt(Integer id,LocalDate dateEmprunt, Emprunteur emprunteur) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.emprunteur = emprunteur;
    }


    public Set<EmpruntDetail> getItems() {
        if (this.empruntsDocuments == null) {
            this.empruntsDocuments = new HashSet<>();
        }
        return empruntsDocuments;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, dateEmprunt, status); // Ne pas inclure `emprunteur` ou `empruntsDocuments`
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Emprunt emprunt = (Emprunt) obj;
        return Objects.equals(id, emprunt.id) &&
                Objects.equals(dateEmprunt, emprunt.dateEmprunt) &&
                Objects.equals(status, emprunt.status);
    }

}
