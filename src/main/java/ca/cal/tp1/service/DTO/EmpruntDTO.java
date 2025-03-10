package ca.cal.tp1.service.DTO;

import ca.cal.tp1.modele.Emprunteur;

import java.time.LocalDate;

public record EmpruntDTO(
        LocalDate dateEmprunt,
        String status,
        Emprunteur emprunteur
) {
}
