package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Data

public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nom;
   private String prenom;
   private String email;
   private String phone;

   public Utilisateur(Integer id, String nom, String prenom, String email, String phone) {
       this.id = id;
       this.nom = nom;
       this.prenom = prenom;
       this.email = email;
       this.phone = phone;
   }




}
