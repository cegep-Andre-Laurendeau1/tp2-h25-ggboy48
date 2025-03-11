package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.exception.*;
import ca.cal.tp2.modele.EmpruntDetail;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface EmpruntRepository {
    void save(Emprunt emprunt) throws DuplicateEntityException;

    Emprunt getEmpruntById(int id) throws EntityNotFoundException;

    List<Emprunt> getAllEmprunts();

}
