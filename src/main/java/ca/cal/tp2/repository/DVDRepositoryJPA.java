package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.DVD;
import jakarta.persistence.EntityManager;

public class DVDRepositoryJPA implements DVDRepository {
    public DVDRepositoryJPA(EntityManager em) {
    }

    @Override
    public void save(DVD entity) throws DuplicateEntityException {
        
    }

    @Override
    public DVD find(long id) {
        return null;
    }
}
