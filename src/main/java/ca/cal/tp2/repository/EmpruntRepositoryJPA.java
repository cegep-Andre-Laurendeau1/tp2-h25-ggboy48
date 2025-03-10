package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpruntRepositoryJPA implements EmpruntRepository {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alrik.pu");

    @Override
    public void save(Emprunt emprunt) throws DuplicateEntityException {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager();) {
            entityManager.getTransaction().begin();
            entityManager.persist(emprunt);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            throw new DuplicateEntityException(e.getMessage());
        }
    }


}
