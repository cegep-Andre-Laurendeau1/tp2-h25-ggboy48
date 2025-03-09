package ca.cal.tp2.modele;

import lombok.Data;

@Data
public abstract class Utilisateur {
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
