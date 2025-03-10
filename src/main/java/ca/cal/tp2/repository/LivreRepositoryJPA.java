package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

public class LivreRepositoryJPA implements LivreRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("herbinate2.ex1");

    public LivreRepositoryJPA(EntityManager em) {
    }

    @Override
    public void save(Livre livre) throws DuplicateEntityException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(livre);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            throw new DuplicateEntityException(e);  // Gérer les exceptions personnalisées
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Livre find(long id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Livre livre = em.find(Livre.class, id);
            em.getTransaction().commit();
            return livre;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
