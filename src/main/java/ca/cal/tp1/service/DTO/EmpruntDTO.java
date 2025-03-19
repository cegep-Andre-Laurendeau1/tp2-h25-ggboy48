package ca.cal.tp1.service.DTO;

import ca.cal.tp1.modele.Emprunt;
import ca.cal.tp1.modele.Emprunteur;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public record EmpruntDTO (
        LocalDate dateEmprunt,
        String status,
        Emprunteur emprunteur
){
    public EmpruntDTO(){
        this(null, null, null);
    }

    public EmpruntDTO toDTO(Emprunt emprunt){
        return new EmpruntDTO(emprunt.getDateEmprunt(), emprunt.getStatus(), emprunt.getEmprunteur());
    }
}
