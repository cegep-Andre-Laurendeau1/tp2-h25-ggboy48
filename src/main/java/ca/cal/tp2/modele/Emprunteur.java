package ca.cal.tp2.modele;


import jakarta.persistence.*;
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


    public Emprunteur(int id, String nom, String prnom ,String email ,String phone) {
        super(id, nom, prnom, email, phone);
    }


    //methode
    public void emprunte(Document document){}
    public void retourneDocument(Document document){}
    public void payerAmende(Double amende){}
    public void rapportHistoriqueEmprunt(){}

}
