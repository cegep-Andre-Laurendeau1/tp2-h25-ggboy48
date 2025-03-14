package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityNotFoundException;

public interface EmprunteurRepository {
    void save(Emprunteur emp) throws DuplicateEntityException;
    Emprunteur getByNomPrenomEmail(String nom, String prenom,String email) throws EntityNotFoundException;
}
