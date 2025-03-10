package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@Data
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nom;
   private String prenom;
   private String email;
   private String phone;

   public Utilisateur(int id, String nom, String prenom, String email, String phone) {
       this.id = id;
       this.nom = nom;
       this.prenom = prenom;
       this.email = email;
       this.phone = phone;
   }

   //methode
public void login(){}

}
