package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

public class DVDRepositoryJPA implements DVDRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.ex1");

    public DVDRepositoryJPA(EntityManager em) {
    }

    @Override
    public void save(DVD dvd) throws DuplicateEntityException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            throw new DuplicateEntityException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DVD find(long id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            DVD dvd = em.find(DVD.class, id);
            em.getTransaction().commit();
            return dvd ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
