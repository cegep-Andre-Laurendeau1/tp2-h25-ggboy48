package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

public class CDRepositoryJPA implements CDRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("herbinate2.ex1");

    public CDRepositoryJPA(EntityManager em) {
    }

    @Override
    public void save(CD cd) throws DuplicateEntityException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(cd);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            throw new DuplicateEntityException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CD find(long id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            CD cd = em.find(CD.class, id);
            em.getTransaction().commit();
            return cd ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
