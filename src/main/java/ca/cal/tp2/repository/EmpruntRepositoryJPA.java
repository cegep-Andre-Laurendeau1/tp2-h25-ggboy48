package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Emprunt;
import jakarta.persistence.*;

import java.util.List;

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


    @Override
    public Emprunt getEmpruntById(int id) throws EntityNotFoundException {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Emprunt emprunt = entityManager.find(Emprunt.class, id);
            if (emprunt == null) {
                throw new EntityNotFoundException("Emprunt with ID " + id + " not found.");
            }
            return emprunt;
        }
    }

    @Override
    public List<Emprunt> getAllEmprunts() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Emprunt> query = entityManager.createQuery("SELECT e FROM Emprunt e", Emprunt.class);
            return query.getResultList();
        }
    }


}
