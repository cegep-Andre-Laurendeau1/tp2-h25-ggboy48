package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.exception.*;

public interface EmpruntRepository {
    void save(Emprunt emprunt) throws DuplicateEntityException;

}
