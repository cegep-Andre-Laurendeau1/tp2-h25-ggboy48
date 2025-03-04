package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Dvd;
import ca.cal.tp1.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DvdRepositoryJPA implements InterfaceRepository<Dvd> {
    private final EntityManagerFactory entityManagerFactory=
            Persistence.createEntityManagerFactory("orders.pu");
    @Override
    public void save(Dvd dvd) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(dvd);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Dvd get(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            TypedQuery<Dvd> query = entityManager.createQuery(
                    "SELECT dvd FROM Dvd dvd " +
                            "WHERE dvd.id = :id", Dvd.class);
            query.setParameter("id", id);
            query.getSingleResult();
            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }    }

    @Override
    public void delete(Long id) {

    }
}
