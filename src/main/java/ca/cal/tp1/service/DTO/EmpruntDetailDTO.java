package ca.cal.tp1.service.DTO;

import ca.cal.tp1.modele.Document;
import ca.cal.tp1.modele.Emprunt;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record EmpruntDetailDTO(
        LocalDate dateRetourPrevue,
        LocalDate dateRetourActuelle,
        String status,
        Emprunt emprunt,
        Document document
) {
}
