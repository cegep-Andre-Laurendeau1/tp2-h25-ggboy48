package ca.cal.tp2.modele;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@ToString
@DiscriminatorValue("Emprunteur")


public class Emprunteur extends Utilisateur {

    @OneToMany(mappedBy = "emprunteur",cascade = CascadeType.PERSIST)
    private Set<Emprunt> emprunts = new HashSet<>();

    @OneToMany(mappedBy = "emprunteur",cascade = CascadeType.PERSIST)
    private Set<Amende> amendes = new HashSet<>();


    public Emprunteur(Integer id, String nom, String prenom, String email, String telephone) {
        super(id, nom, prenom, email, telephone);
    }



    //methode
    public void emprunte(Document document){}
    public void retourneDocument(Document document){}
    public void payerAmende(Double amende){}
    public void rapportHistoriqueEmprunt(){}

}
