package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UtilisateurDTO {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;

    public static UtilisateurDTO toDto(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }
        if (utilisateur instanceof Emprunteur) {
            Emprunteur emprunteur = (Emprunteur) utilisateur;
            return new EmprunteurDTO(emprunteur.getId(), emprunteur.getNom(), emprunteur.getPrenom(), emprunteur.getEmail(), emprunteur.getPhone());
        }
        if(utilisateur instanceof Prepose){
            Prepose prepose = (Prepose) utilisateur;
            return new PreposeDTO(prepose.getId(), prepose.getNom(), prepose.getPrenom(), prepose.getEmail(), prepose.getPhone(), prepose.getRole());
        }




        return null;
    }



}
