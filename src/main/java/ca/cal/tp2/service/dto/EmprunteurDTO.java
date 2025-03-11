package ca.cal.tp2.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmprunteurDTO extends UtilisateurDTO{

    private List<Integer> empruntsIds;

    public EmprunteurDTO(Integer id, String nom, String prenom, String email, String phone) {
        super(id, nom, prenom, email, phone);
        this.empruntsIds = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "EmprunteurDTO [Nom=" + getNom() + ", Prenom=" + getPrenom() + ", Email=" + getEmail() + ", phone= " + getPhone() + "]";
    }
}
