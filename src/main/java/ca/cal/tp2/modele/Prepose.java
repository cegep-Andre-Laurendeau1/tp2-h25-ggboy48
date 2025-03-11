package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Data


public class Prepose extends Utilisateur {
    private String role;


    public Prepose(int id, String nom, String prenom, String email, String phone, String role) {
        super(id, nom, prenom, email, phone);
        this.role = role;

    }


}
