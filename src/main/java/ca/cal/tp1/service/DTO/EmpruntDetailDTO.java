package ca.cal.tp1.service.DTO;

import ca.cal.tp1.modele.Document;
import ca.cal.tp1.modele.Emprunt;
import ca.cal.tp1.modele.EmpruntDetails;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public record EmpruntDetailDTO(
        LocalDate dateRetourPrevue,
        LocalDate dateRetourActuelle,
        String status,
        Emprunt emprunt,
        Document document
) {
    public EmpruntDetailDTO(){
        this(null, null, null, null, null);
    }

    public EmpruntDetailDTO toDTO(EmpruntDetails empruntDetail) {
        return new EmpruntDetailDTO(empruntDetail.getDateRetourPrevue(), empruntDetail.getDateRetourActuelle(), empruntDetail.getStatus(), empruntDetail.getEmprunt(), empruntDetail.getDocument());
    }
}
