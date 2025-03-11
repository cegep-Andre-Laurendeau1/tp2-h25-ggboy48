package ca.cal.tp2.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreposeDTO extends UtilisateurDTO {
    private String role;

    public PreposeDTO(Integer id, String nom, String prenom, String email, String phone, String role) {
        super(id, nom, prenom, email, phone);
        this.role = role;
    }
}
