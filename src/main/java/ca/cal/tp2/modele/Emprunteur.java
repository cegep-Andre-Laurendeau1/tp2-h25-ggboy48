package ca.cal.tp2.modele;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@ToString
@Table (name="Emprunteur")
@DiscriminatorValue("Emprunteur")


public class Emprunteur extends Utilisateur {

    @OneToMany(mappedBy = "emprunteur",cascade = CascadeType.PERSIST)
    private Set<Emprunt> emprunts = new HashSet<>();

    @OneToMany(mappedBy = "emprunteur",cascade = CascadeType.PERSIST)
    private Set<Amende> amendes = new HashSet<>();


    public Emprunteur(Integer id, String nom, String prenom, String email, String telephone) {
        super(id, nom, prenom, email, telephone);
        this.emprunts = new HashSet<>();
        this.amendes = new HashSet<>();
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getPrenom(), getEmail(), getPhone());  // Ne pas inclure `emprunts` ou `amendes`
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Emprunteur emprunteur = (Emprunteur) obj;
        return Objects.equals(getId(), emprunteur.getId()) &&
                Objects.equals(getNom(), emprunteur.getNom()) &&
                Objects.equals(getPrenom(), emprunteur.getPrenom()) &&
                Objects.equals(getEmail(), emprunteur.getEmail()) &&
                Objects.equals(getPhone(), emprunteur.getPhone());
    }




}
