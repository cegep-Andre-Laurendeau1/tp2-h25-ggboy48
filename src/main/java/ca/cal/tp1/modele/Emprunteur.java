package ca.cal.tp1.modele;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Emprunteur extends Utilisateur {
    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    List<Amende> amendes;
    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    List<Emprunt> emprunts;
    public Emprunteur(String nom, String prenom, String courriel) {
        super(nom, prenom, courriel);
    }
}
