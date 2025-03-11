package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import jakarta.persistence.*;

import java.util.List;

public class EmpruntRepositoryJPA implements EmpruntRepository {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alrik.pu");
    @Override
    public void save(Emprunt emprunt) throws DuplicateEntityException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            if (emprunt.getId() == null) {
                // C'est un nouvel emprunt => On peut le persister
                entityManager.persist(emprunt);
            } else {
                // C'est un emprunt existant => On doit utiliser merge
                emprunt = entityManager.merge(emprunt);
            }

            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new DuplicateEntityException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


    @Override
    public Emprunt getEmpruntById(int id) throws EntityNotFoundException {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Emprunt emprunt = entityManager.find(Emprunt.class, id);
            if (emprunt == null) {
                throw new EntityNotFoundException("Emprunt avec ce ID " + id + " nest pas trouvé.");
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
